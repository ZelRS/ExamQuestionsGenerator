package ru.skypro.examquestionsgenerator.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.examquestionsgenerator.exception.AmountException;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.service.ExaminerService;
import ru.skypro.examquestionsgenerator.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.shuffle;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questions = new ArrayList<>();
        questions.addAll(javaQuestionService.getAll());
        questions.addAll(mathQuestionService.getAll());
        shuffle(questions);
        if (amount > questions.size()) {
            throw new AmountException("В хранилище всего " + questions.size() + " вопросов!");
        }
        if (amount <= 0) {
            throw new AmountException("Количество вопросов не может быть меньше 1!");
        }
        return questions.stream().limit(amount).collect(Collectors.toSet());
    }
}
