package com.kakao.springbootjpa.dto;

import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoDTO {
    private Long mno;
    private String memoText;
}

