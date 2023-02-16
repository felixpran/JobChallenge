package main.validators;

import main.enums.InputTypes;
import main.exceptions.InvalidInputException;

public class InputValidator implements  Validator {
    @Override
    public boolean validate(String inputLine, InputTypes type) throws InvalidInputException {
        return false;
    }
}
