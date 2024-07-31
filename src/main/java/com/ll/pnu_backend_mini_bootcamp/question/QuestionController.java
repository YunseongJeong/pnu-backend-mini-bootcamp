package com.ll.pnu_backend_mini_bootcamp.question;

import com.ll.pnu_backend_mini_bootcamp.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<Question> questions = this.questionService.getQuestionList();
        model.addAttribute("questionList", questions);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable(value = "id") int id, AnswerForm answerForm){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String create(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/create")
    public String create(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:list";
    }
}
