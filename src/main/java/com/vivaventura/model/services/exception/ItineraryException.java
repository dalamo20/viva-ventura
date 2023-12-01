package com.vivaventura.model.services.exception;

public class ItineraryException extends Exception {
    private static final long serialVersionUID = 1L;

    public ItineraryException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
