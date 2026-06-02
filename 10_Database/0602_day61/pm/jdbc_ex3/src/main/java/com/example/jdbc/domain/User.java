package com.example.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Domain
 * ------------------------------------------------------------
 * users 테이블과 매핑되는 객체입니다.
 *
 *
 * - id: DB 내부 PK, AUTO_INCREMENT
 * - userId: 사용자가 로그인할 때 사용하는 계정 ID
 *
 * 즉, id와 userId의 역할을 분리합니다.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String userId;

    private String username;

    private String userPassword;

    private Integer userAge;

    private String userEmail;
}
