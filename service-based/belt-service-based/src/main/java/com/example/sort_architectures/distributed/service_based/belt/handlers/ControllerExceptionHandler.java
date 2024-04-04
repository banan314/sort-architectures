package com.example.sort_architectures.distributed.service_based.belt.handlers;

import com.example.sort_architectures.distributed.service_based.belt.dto.ExceptionDto;
import com.example.sort_architectures.distributed.service_based.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.service_based.belt.exceptions.ItemsSortingException;
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
