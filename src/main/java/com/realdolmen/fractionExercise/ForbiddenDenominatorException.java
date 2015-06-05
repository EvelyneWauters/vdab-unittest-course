package com.realdolmen.fractionExercise;

import com.sun.xml.internal.ws.api.model.CheckedException;

/**
 * Created by jeansmits on 04/06/15.
 */
public class ForbiddenDenominatorException extends ArithmeticException {
    private String description;

    public ForbiddenDenominatorException(String s, String description) {
        super(s);
        this.description = description;
    }

    public ForbiddenDenominatorException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
