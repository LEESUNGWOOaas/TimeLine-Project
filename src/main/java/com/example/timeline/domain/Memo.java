package com.example.timeline.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자 자동 생성
@Entity // 테이블과 연계됨을 스프링에 정보 전달
public class Memo extends Timestamped { // 생성,수정 시간을 자동생성
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
    public void update (MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
