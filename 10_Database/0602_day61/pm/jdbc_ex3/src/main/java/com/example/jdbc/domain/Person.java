package com.example.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person Domain
 * ------------------------------------------------------------
 * person 테이블과 매핑되는 객체입니다.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;

    private String name;
}
