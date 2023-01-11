package com.kakao.springbootjpa.persistence;

import com.kakao.springbootjpa.domain.Memo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //mno의 값이 from부터 to 사이인 데이터 조회하는 메서드
    List<Memo> findByMnoBetween(Long from, Long to);

    //mno의 값이 from부터 to 사이인 데이터를 mno의 내림차순 정렬해서 조회하는 메서드
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    //페이징을 적용해서 조회
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteByMnoLessThan(Long num);

    //mno와 memoText를 매개변수로 받아서 수정하는 메서드 - JPQL 사용
    //Native SQL이 아니기 때문에 Table 이름을 적는 것이 아니고
    //Entity 클래스의 이름을 사용해야 함
    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno ")
    public int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText );

    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno} ")
    public int updateMemoText(@Param("param") Memo memo );

    @Query("select m from Memo m where m.mno > :mno")
    Page<Memo> getListWithQuery(@Param("mno") Long mno, Pageable pageable);

    @Query(value = "select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno > :mno")
    Page<Object[]> getObjectWithQuery(@Param("mno") Long mno, Pageable pageable);


}