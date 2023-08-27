package ru.skypro.examquestionsgenerator.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examquestionsgenerator.model.Question;
import ru.skypro.examquestionsgenerator.repository.QuestionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    void shouldAddQuestionWithFields() {
        when(questionRepositoryMock.add(QUESTION, ANSWER)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.add(QUESTION, ANSWER));
    }

    @Test
    void shouldAddQuestionWithObject() {
        when(questionRepositoryMock.add(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.add(QUESTION1));
    }

    @Test
    void shouldRemoveQuestionWithObject() {
        when(questionRepositoryMock.remove(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(QUESTION1, out.remove(QUESTION1));
    }

    @Test
    void shouldGetAllQuestionsOfStorage() {
        when(questionRepositoryMock.getAll()).thenReturn(EXPECTED2);
        assertEquals(EXPECTED2, out.getAll());
    }

    @Test
    void ShouldGetRandomQuestionFromStorage() {
        when(questionRepositoryMock.getAll()).thenReturn(EXPECTED1);
        Question[] expected = EXPECTED1.toArray(EXPECTED1.toArray(new Question[0]));
        out.add(QUESTION1);
        assertEquals(expected[0], out.getRandomQuestion());
    }
}
