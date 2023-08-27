package ru.skypro.examquestionsgenerator.constants;

import ru.skypro.examquestionsgenerator.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceImplTestConstants {
    public static final String QUESTION = "Test1?";
    public static final String ANSWER = "Test1";
    public static final Question QUESTION1 = new Question(QUESTION, ANSWER);
    public static final Collection<Question> EXPECTED1 = new HashSet<>(Set.of(QUESTION1));
    public static final Collection<Question> EXPECTED2 = new HashSet<>();
}
