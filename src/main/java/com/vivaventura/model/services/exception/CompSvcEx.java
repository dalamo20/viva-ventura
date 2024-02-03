package com.vivaventura.model.services.exception;

public class CompSvcEx extends Exception {
    private static final long serialVersionUID = 1L;

    public CompSvcEx(final String inMessage)
    {
        super(inMessage);
    }

    public CompSvcEx(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
