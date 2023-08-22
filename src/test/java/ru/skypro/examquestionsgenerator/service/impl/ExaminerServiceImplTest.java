package ru.skypro.examquestionsgenerator.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examquestionsgenerator.exception.AmountException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.EXPECTED1;
import static ru.skypro.examquestionsgenerator.constants.JavaQuestionServiceImplTestConstants.QUESTION1;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void ShouldGetQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(EXPECTED1);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(QUESTION1);
        assertEquals(EXPECTED1, out.getQuestions(1));
    }

    @Test
    void ShouldThrowIfAmountLessThanOrEqualToZero() {
        assertThrows(AmountException.class, () -> out.getQuestions(5));
    }

    @Test
    void ShouldThrowIfAmountMoreThanStorageSize() {
        assertThrows(AmountException.class, () -> out.getQuestions(0));
    }
}