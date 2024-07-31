package com.ll.pnu_backend_mini_bootcamp.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
