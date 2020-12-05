package com.texus.devtest.mrc.exception;

public class InputValidationException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InputValidationException(String errorMessage) {
        super(errorMessage);
    }

}
