package com.ll.pnu_backend_mini_bootcamp.answer;

import com.ll.pnu_backend_mini_bootcamp.DataNotFoundException;
import com.ll.pnu_backend_mini_bootcamp.User.SiteUser;
import com.ll.pnu_backend_mini_bootcamp.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id){
        Optional<Answer> _answer = answerRepository.findById(id);
        if (_answer.isPresent()){
            return _answer.get();
        }
        throw new DataNotFoundException("answer not found");
    }

    public void modify(Answer answer, String content ){
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser){
        answer.getVoter().add(siteUser);
        answerRepository.save(answer);
    }
}
