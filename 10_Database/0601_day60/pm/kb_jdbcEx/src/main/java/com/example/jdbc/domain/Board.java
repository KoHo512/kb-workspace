package com.example.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime date;
    private String fileName;
    private byte[] fileDate;
}
