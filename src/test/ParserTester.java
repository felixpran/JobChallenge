package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.enums.RomanNumerals;
import main.exceptions.InvalidInputException;
import main.exceptions.InvalidRomanNumeralException;
import main.exceptions.InvalidUnitTokenException;
import main.parsers.InputParser;
import main.parsers.Parser;
import main.services.MapManager;
import main.validators.InputValidator;
import main.validators.Validator;

public class ParserTester {

    private Parser parser;
    private MapManager mapManager;
    private Validator validator;

    @Before
    public void setup() {
        validator = new InputValidator();
        parser = new InputParser(validator);
        mapManager = MapManager.getInstance();
    }

    @Test
    public void testUnitToRomanNumeralsValid() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is V");
        parser.parse("pish is X");
        parser.parse("tegj is L");
        Assert.assertEquals(RomanNumerals.I, mapManager.getRomanNumeralByUnit("glob"));
        Assert.assertEquals(RomanNumerals.V, mapManager.getRomanNumeralByUnit("prok"));
        Assert.assertEquals(RomanNumerals.X, mapManager.getRomanNumeralByUnit("pish"));
        Assert.assertEquals(RomanNumerals.L, mapManager.getRomanNumeralByUnit("tegj"));
    }

    @Test(expected = InvalidRomanNumeralException.class)
    public void testUnitToRomanNumeralsInvalid() throws InvalidInputException {
        parser.parse("glob is P");
        parser.parse("prok is K");
        parser.parse("pish is Y");
        parser.parse("tegj is O");
    }

    @Test(expected = InvalidUnitTokenException.class)
    public void testCommodityInvalid() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is V");
        parser.parse("pish is X");
        parser.parse("tegj is L");
        parser.parse("abc xyz Silver is 34 Credits");
    }


    @Test(expected = InvalidUnitTokenException.class)
    public void testQuestionInvalid() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is V");
        parser.parse("pish is X");
        parser.parse("tegj is L");
        parser.parse("How much is abc klmn?");
    }

    // Testing rule: "I", "X", "C", and "M" can be repeated three times in succession, but no more
    @Test(expected = InvalidUnitTokenException.class)
    public void testIvalidSequence_I() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is C");
        parser.parse("pish is X");
        parser.parse("tegj is M");
        parser.parse("How much is glob glob glob glob?");
    }

    // Testing rule: "I", "X", "C", and "M" can be repeated three times in succession, but no more
    @Test(expected = InvalidUnitTokenException.class)
    public void testIvalidSequence_X() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is C");
        parser.parse("pish is X");
        parser.parse("tegj is M");
        parser.parse("How much is pish pish pish pish?");
    }

    // Testing rule: "I", "X", "C", and "M" can be repeated three times in succession, but no more
    @Test(expected = InvalidUnitTokenException.class)
    public void testIvalidSequence_C() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is C");
        parser.parse("pish is X");
        parser.parse("tegj is M");
        parser.parse("How much is prok prok prok prok?");
    }

    // Testing rule: "I", "X", "C", and "M" can be repeated three times in succession, but no more
    @Test(expected = InvalidUnitTokenException.class)
    public void testIvalidSequence_M() throws InvalidInputException {
        parser.parse("glob is I");
        parser.parse("prok is C");
        parser.parse("pish is X");
        parser.parse("tegj is M");
        parser.parse("How much is tegj tegj tegj tegj?");
    }
}
