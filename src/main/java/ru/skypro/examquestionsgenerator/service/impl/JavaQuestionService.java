package ru.skypro.examquestionsgenerator.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question ques = new Question(question, answer);
        questions.add(ques);
        return ques;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question[] array = questions.toArray(Question[]::new);
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}
