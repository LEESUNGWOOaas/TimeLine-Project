package com.example.timeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // jpa 사용할 때 데이터 변동시 자동 반영(수정시간이 변동 Timestamped 변경에 필요)
@SpringBootApplication
public class TimelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimelineApplication.class, args);
    }

}
