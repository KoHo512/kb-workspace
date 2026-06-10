package org.scoula.module2.domain;


import lombok.*;

import java.util.List;

//문제 8-1.
// VO 객체로 사용할 Country를 완성하세요.
// Lombok 어노테이션 설정
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Country {
    private String code;
    private String name;
    private String continent;
    private float surfaceArea;

    private List<City> cities;
}
