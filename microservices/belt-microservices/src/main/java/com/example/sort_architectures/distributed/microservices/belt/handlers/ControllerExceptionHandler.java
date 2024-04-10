package com.example.sort_architectures.distributed.microservices.belt.handlers;

import com.example.sort_architectures.distributed.microservices.belt.dto.ExceptionDto;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemsSortingException;
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
