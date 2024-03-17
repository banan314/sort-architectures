package org.example.monolith.layered.controllers.handlers;

import org.example.monolith.layered.dto.ExceptionDto;
import org.example.monolith.layered.exceptions.ItemPopppingException;
import org.example.monolith.layered.exceptions.ItemsSortingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ItemPopppingException.class)
    public ExceptionDto popItemException(final ItemPopppingException e) {
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(ItemsSortingException.class)
    public ExceptionDto sortItemsException(final ItemsSortingException e) {
        return new ExceptionDto(e.getMessage());
    }
}
