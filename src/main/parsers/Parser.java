package main.parsers;

import main.exceptions.InvalidInputException;

import java.util.Map;

public interface Parser {


   public void parse(String inputLine) throws InvalidInputException;


}
