package com.kakao.board.board;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;

    private String writerEmail; //사용자의 이메일
    private String writerName; //사용자의 이름
    private LocalDateTime regDate; //등록한 날짜
    private LocalDateTime modDate; //수정된 날짜
    private int replyCount;
}
