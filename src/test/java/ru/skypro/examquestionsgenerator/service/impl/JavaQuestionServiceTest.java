package ru.skypro.examquestionsgenerator.service.impl;

import org.junit.jupiter.api.Test;
import ru.skypro.examquestionsgenerator.model.Question;

import static org.junit.jupiter.api.Assertions.*;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    void shouldAddQuestionWithFields() {
        out.add(QUESTION, ANSWER);
        assertEquals(EXPECTED1, out.getAll());
    }

    @Test
    void shouldAddQuestionWithObject() {
        out.add(QUESTION1);
        assertEquals(EXPECTED1, out.getAll());
    }

    @Test
    void shouldRemoveQuestionWithObject() {
        out.add(QUESTION1);
        out.remove(QUESTION1);
        assertEquals(EXPECTED2, out.getAll());
    }

    @Test
    void shouldGetAllQuestionsOfStorage() {
        assertEquals(EXPECTED2, out.getAll());
    }

    @Test
    void ShouldGetRandomQuestionFromStorage() {
        Question[] expected = EXPECTED1.toArray(EXPECTED1.toArray(new Question[0]));
        out.add(QUESTION1);
        assertEquals(expected[0], out.getRandomQuestion());
    }
}
