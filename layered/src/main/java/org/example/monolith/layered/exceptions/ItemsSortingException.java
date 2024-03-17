package org.example.monolith.layered.exceptions;

import java.io.Serial;

@SuppressWarnings("unused")
public class ItemsSortingException extends Exception {
    @Serial
    private static final long serialVersionUID = -1637190358778929417L;

    public ItemsSortingException() {
    }

    public ItemsSortingException(final String message) {
        super(message);
    }

    public ItemsSortingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ItemsSortingException(final Throwable cause) {
        super(cause);
    }

    public ItemsSortingException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
