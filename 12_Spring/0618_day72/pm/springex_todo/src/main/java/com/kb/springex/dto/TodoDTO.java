package com.kb.springex.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 서버 사이드 필드 검증
public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;
}
