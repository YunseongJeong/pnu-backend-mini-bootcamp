package com.ll.pnu_backend_mini_bootcamp.answer;

import com.ll.pnu_backend_mini_bootcamp.question.Question;
import com.ll.pnu_backend_mini_bootcamp.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable(value = "id") int id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = questionService.getQuestion(id);
        if (bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }
        answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
