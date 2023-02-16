package main.validators;

import main.enums.InputTypes;
import main.exceptions.InvalidInputException;

public interface Validator {


    /**
     * RULES:
     * 1. Occurrence:
     * --- The symbols "I", "X", "C", and "M" can be repeated three times in succession
     * --- "D", "L", and "V" can never be repeated.
     * 2. Subtraction:
     * --- "I" can be subtracted from "V" and "X" only.
     * --- "X" can be subtracted from "L" and "C" only.
     * --- "C" can be subtracted from "D" and "M" only.
     * --- "V", "L", and "D" can never be subtracted
     * --- Only one small-value symbol may be subtracted from any large-value symbol.
     */

    public boolean validate(String inputLine, InputTypes type) throws InvalidInputException;
}
