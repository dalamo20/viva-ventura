package com.vivaventura.model.services.exception;

public class LoginException extends Exception {
    private static final long serialVersionUID = 6009821813727278428L;


    public LoginException(final String inMessage)
    {
        super(inMessage);
    }


    public LoginException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
