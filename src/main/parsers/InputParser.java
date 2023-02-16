package main.parsers;

import main.exceptions.InvalidInputException;
import main.validators.Validator;

public class InputParser implements Parser {

    private Validator validator;

    public InputParser(Validator validator){
        this.validator = validator;
    }

    @Override
    public void parse(String inputLine) throws InvalidInputException {

    }
}
