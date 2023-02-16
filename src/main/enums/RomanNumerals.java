package main.enums;


public enum RomanNumerals {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int arabicValue;

    private RomanNumerals(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public String getRomanNumeral() {
        return this.toString();
    }

    public static RomanNumerals getRomanNumeralFromArabic(int arabicValue) {
        for (RomanNumerals romanNumeral : values()) {
            if (romanNumeral.arabicValue == arabicValue) {
                return romanNumeral;
            }
        }
        return null;
    }

}

