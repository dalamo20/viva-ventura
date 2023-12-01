package com.vivaventura.model.services.exception;

public class UserException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserException(final String inMessage)
    {
        super(inMessage);
    }

    public UserException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
