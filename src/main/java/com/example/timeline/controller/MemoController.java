package com.example.timeline.controller;

import com.example.timeline.domain.Memo;
import com.example.timeline.domain.MemoRepository;
import com.example.timeline.domain.MemoRequestDto;
import com.example.timeline.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody  MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        LocalDateTime now = LocalDateTime.now(); // 현재시간
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1); // 하루전의 시간
       return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday,now);// 하루전의 데이터부터 지금까지의 시간을 가져옴
    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody  MemoRequestDto requestDto){
    memoService.update(id, requestDto);
    return id;
    }
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
}
