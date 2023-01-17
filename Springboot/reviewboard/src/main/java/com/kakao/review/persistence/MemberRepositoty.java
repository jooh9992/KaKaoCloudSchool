package com.kakao.review.persistence;

import com.kakao.review.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoty extends JpaRepository<Member, Long> {
}
