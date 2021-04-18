package com.example.timeline.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemoRequestDto {

    private String username;
    private String contents;
}
