package ru.skypro.examquestionsgenerator.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.examquestionsgenerator.exception.AmountException;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.service.ExaminerService;
import ru.skypro.examquestionsgenerator.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new AmountException("В хранилище всего " + javaQuestionService.getAll().size()
                    + " вопросов!");
        }
        if (amount <= 0) {
            throw new AmountException("Количество вопросов не может быть меньше 1!");
        }
        Set<Question> examQuestions = new HashSet<>();
        int iter = 1;
        while (iter <= amount) {
            examQuestions.add(javaQuestionService.getRandomQuestion());
            iter++;
        }
        return examQuestions;
    }
}
