package com.ll.pnu_backend_mini_bootcamp.question;

import com.ll.pnu_backend_mini_bootcamp.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question getQuestion(int id){
        Optional<Question> oq = questionRepository.findById(id);
        if (oq.isPresent()){
            return oq.get();
        }
        throw new DataNotFoundException("question not found");
    }

    public void create(String subject, String content){
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }

    public Page<Question> getQuestionList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        return questionRepository.findAll(pageable);
    }
}
