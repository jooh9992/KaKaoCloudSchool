package com.kakao.guestbook.service;

import com.kakao.guestbook.domain.GuestBook;
import com.kakao.guestbook.dto.GuestBookDTO;
import com.kakao.guestbook.dto.PageRequestDTO;
import com.kakao.guestbook.dto.PageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface GuestBookService {
    //데이터 삽입을 위한 메서드 - 기본키의 값 리턴
    //매개변수는 대부분의 경우 DTO
    //리턴 타입은 삽입된 데이터를 그대로 리턴하기도 하고
    //성공과 실패 여부를 위해서 boolean을 리턴하기도 하고
    //영향받은 행의 개수를 의미하는 int를 리턴하기도 하고
    //기본키의 값을 리턴하는 경우도 있음
    public long register(GuestBookDTO dto);

    PageResponseDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO requestDTO);

    //DTO를 Entity로 변환해주는 메서드
    default GuestBook dtoToEntity(GuestBookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }
    //entity를 dto로 변환해주는 메서드
    //전부 옮겨 주어야 함
    default GuestBookDTO entityToDto(GuestBook entity){
        GuestBookDTO dto = GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

}
