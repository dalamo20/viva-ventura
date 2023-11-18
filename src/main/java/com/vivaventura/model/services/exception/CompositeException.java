package com.vivaventura.model.services.exception;

public class CompositeException extends Exception {
    private static final long serialVersionUID = 1L;

    public CompositeException(final String inMessage)
    {
        super(inMessage);
    }

    public CompositeException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
