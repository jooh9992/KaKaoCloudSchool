package com.kakao.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.util.Lazy;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")//toString을 만들 때 writer의 toString 호출 안함
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    //처음에는 가져오지 않고 사용할 때 가져옴
    private Member writer;//Member 테이블을 참조할 수 있는 관계설정

    //title을 수정하는 메서드
    public void changeTitle(String title){
        if(title==null || title.trim().length() == 0){
            this.title ="무제";
            return;
        }
        this.title = title;
    }
    //content를 수정하는 메서드
    public void changeContent(String content){
        this.content = content;
    }
}