package com.example.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Board Domain
 * ------------------------------------------------------------
 * boards 테이블과 매핑되는 객체입니다.
 * bfiledata는 MySQL LONGBLOB과 매핑되며 Java에서는 byte[]로 다룹니다.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Integer bno;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdAt;

    private String fileName;

    private byte[] fileData;
}
