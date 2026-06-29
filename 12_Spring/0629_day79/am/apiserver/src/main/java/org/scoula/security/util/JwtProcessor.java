package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    static private final long TOKEN_VALID_MILLISECOND = 1000L * 60 * 5; // 5분

    // 개발 시에는 직접 지정해서 사용 (동일 환경 검증을 위해)
    private String secretKey = "faajksdhkjfhsdfgsdgfdsfdgdfrgserggfsdfafsdfdhasdfhasdk";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // 운영 시에는 자동 생성 혹은 환경 변수로 등록
    // -- 자동 생성하면, 서버 재가동 시 문자열이 갱신되므로 기존 토큰 사용 불가능
    //     = 여러 서버가 운영되는 경우는 별도의 secret key를 공유해야 함
//    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // JWT 생성
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILLISECOND))
                .signWith(key)
                .compact();
    }

    // JWT Subject 추출
    // -- 해석 불가능한 경우 예외 발생 - 대부분 ExpiredJwtException
    // -- username 꺼내면서 자연스럽게 validation 체크도 됨
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 검증
    // -- 해석이 불가능해서 예외가 발생한 경우 검증 실패
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return true;
    }
}
