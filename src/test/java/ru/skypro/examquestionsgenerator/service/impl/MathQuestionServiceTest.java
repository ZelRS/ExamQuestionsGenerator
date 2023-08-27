package ru.skypro.examquestionsgenerator.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.repository.impl.MathQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void shouldAddQuestionWithFields() {
        when(mathQuestionRepositoryMock.add(QUESTION, ANSWER)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.add(QUESTION, ANSWER));
    }

    @Test
    void shouldAddQuestionWithObject() {
        when(mathQuestionRepositoryMock.add(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.add(QUESTION1));
    }

    @Test
    void shouldRemoveQuestionWithObject() {
        when(mathQuestionRepositoryMock.remove(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.remove(QUESTION1));
    }

    @Test
    void shouldGetAllQuestionsOfStorage() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(EXPECTED2);
        assertEquals(EXPECTED2, out.getAll());
    }

    @Test
    void ShouldGetRandomQuestionFromStorage() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(EXPECTED1);
        Question[] expected = EXPECTED1.toArray(EXPECTED1.toArray(new Question[0]));
        out.add(QUESTION1);
        assertEquals(expected[0], out.getRandomQuestion());
    }
}