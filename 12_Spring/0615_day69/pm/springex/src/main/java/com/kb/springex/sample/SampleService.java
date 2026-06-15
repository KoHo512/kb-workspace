package com.kb.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {
    // 필드 주입 방식
//    @Autowired
//    private SampleDAO sampleDAO;

    // 생성자 주입 방식
    @Qualifier("normal")
    private final SampleDAO sampleDAO;

//    public SampleService(SampleDAO sampleDAO) {
//        this.sampleDAO = sampleDAO;
//    }
}
