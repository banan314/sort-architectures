package com.example.sort_architectures.distributed.event_driven.exceptions;

import java.io.Serial;

@SuppressWarnings("unused")
public class ItemPopppingException extends Exception {
    @Serial
    private static final long serialVersionUID = -1225743297850917570L;

    public ItemPopppingException() {
    }

    public ItemPopppingException(final String message) {
        super(message);
    }

    public ItemPopppingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ItemPopppingException(final Throwable cause) {
        super(cause);
    }

    public ItemPopppingException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
