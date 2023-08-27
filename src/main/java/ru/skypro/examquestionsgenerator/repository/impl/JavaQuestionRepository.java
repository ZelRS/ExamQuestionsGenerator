package ru.skypro.examquestionsgenerator.repository.impl;

import org.springframework.stereotype.Repository;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("Сколько месяцев в году?", "12"));
        questions.add(new Question("Сколько времен года?", "4"));
        questions.add(new Question("Столица Италии?", "Рим"));
        questions.add(new Question("Столицы Австрии?", "Вена"));
        questions.add(new Question("Кто написал картину \"Грачи прилетели\"?", "Саврасов"));
        questions.add(new Question("Что делал кот-ученый, когда ходил по цепи налево?", "Заводил песнь"));
        questions.add(new Question("Первый месяц в году?", "Январь"));
        questions.add(new Question("Столица Японии?", "Токио"));
        questions.add(new Question("Столица Тайланда?", "Бангкок"));
        questions.add(new Question("В каком шате находится город Лос-Анжелес?", "Калифорния"));
    }

    @Override
    public Question add(String question, String answer) {
        Question que = new Question(question, answer);
        questions.add(que);
        return que;
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
}
