package com.kb.webapp_todo.todo.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDateTime dueDate;
    private boolean finished;
}
