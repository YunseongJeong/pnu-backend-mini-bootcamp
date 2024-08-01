package com.ll.pnu_backend_mini_bootcamp;

import com.ll.pnu_backend_mini_bootcamp.question.Question;
import com.ll.pnu_backend_mini_bootcamp.question.QuestionRepository;
import com.ll.pnu_backend_mini_bootcamp.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PnuBackendMiniBootcampApplicationTests {

	@Autowired
	private QuestionService questionService;

}
