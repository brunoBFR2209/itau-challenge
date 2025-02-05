package com.challenge.pet.love.infra.handler;

import com.challenge.pet.love.infra.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CustomHandlerTest {

    @InjectMocks
    private CustomHandler customHandler;

    @Test
    void handleEntityExceptionReturnsUnprocessableEntityWithCorrectMessage() {
        String message = "Test business exception message";
        BusinessException exception = new BusinessException(message);

        ResponseEntity<String> response = customHandler.handleEntityException(exception);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    void handleEntityExceptionReturnsUnprocessableEntityWithDifferentMessage() {
        String message = "Another test message";
        BusinessException exception = new BusinessException(message);

        ResponseEntity<String> response = customHandler.handleEntityException(exception);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    void handleEntityExceptionHandlesSubclassOfBusinessException() {

        class SpecificBusinessException extends BusinessException {
            public SpecificBusinessException(String message) {
                super(message);
            }
        }

        String message = "Specific exception message";
        SpecificBusinessException exception = new SpecificBusinessException(message);

        ResponseEntity<String> response = customHandler.handleEntityException(exception);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    void handleEntityExceptionHandlesNullMessage() {
        BusinessException exception = new BusinessException(null);
        ResponseEntity<String> response = customHandler.handleEntityException(exception);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertNull(response.getBody());
    }
}