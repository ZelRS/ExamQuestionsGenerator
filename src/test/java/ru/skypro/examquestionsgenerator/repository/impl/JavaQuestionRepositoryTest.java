package ru.skypro.examquestionsgenerator.repository.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.*;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

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
}