package ru.skypro.examquestionsgenerator.repository.impl;

import org.springframework.stereotype.Repository;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> mathQuestions;

    public MathQuestionRepository() {
        this.mathQuestions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        mathQuestions.add(new Question("5+66", "71"));
        mathQuestions.add(new Question("6*7", "42"));
        mathQuestions.add(new Question("18-11", "7"));
        mathQuestions.add(new Question("105+206", "311"));
        mathQuestions.add(new Question("467-21", "446"));
        mathQuestions.add(new Question("20/4", "5"));
        mathQuestions.add(new Question("9*9", "81"));
        mathQuestions.add(new Question("64-0", "64"));
        mathQuestions.add(new Question("111+62", "173"));
        mathQuestions.add(new Question("764+164", "928"));
    }

    @Override
    public Question add(String question, String answer) {
        Question que = new Question(question, answer);
        mathQuestions.add(que);
        return que;
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions;
    }
}
