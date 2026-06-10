package org.scoula.module2.domain;


import lombok.*;

//문제 5-1.
// VO 객체로 사용할 City를 완성하세요.
// Lombok 어노테이션 설정
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
}
