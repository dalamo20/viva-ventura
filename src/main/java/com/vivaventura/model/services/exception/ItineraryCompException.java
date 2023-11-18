package com.vivaventura.model.services.exception;

public class ItineraryCompException extends Exception {
    private static final long serialVersionUID = 1L;

    public ItineraryCompException(final String inMessage)
    {
        super(inMessage);
    }

    public ItineraryCompException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
