package com.example.monolith.modular.belt.handlers;

import com.example.monolith.modular.belt.dto.ExceptionDto;
import com.example.monolith.modular.belt.exceptions.ItemPopppingException;
import com.example.monolith.modular.belt.exceptions.ItemsSortingException;
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
