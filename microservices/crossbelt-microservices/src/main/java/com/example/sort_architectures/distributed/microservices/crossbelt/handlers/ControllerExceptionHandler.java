package com.example.sort_architectures.distributed.microservices.crossbelt.handlers;

import com.example.sort_architectures.distributed.microservices.crossbelt.dto.ExceptionDto;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.ItemsSortingException;
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

    @ExceptionHandler(BeltServiceException.class)
    public ExceptionDto beltServiceException(final BeltServiceException e) {
        return new ExceptionDto(e.getMessage());
    }
}
