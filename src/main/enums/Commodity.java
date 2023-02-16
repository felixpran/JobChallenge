package main.enums;

public enum Commodity {

    SILVER("Silver"),
    IRON("Iron"),
    GOLD("Gold");

    private String metalType;

    private Commodity(String metalType) {
        this.metalType = metalType;
    }

    public String getValue() {
        return metalType;
    }

    public static Commodity getCommodityByValue(String value) {
        for (Commodity commodity : values()) {
            if (commodity.metalType.equals(value)) {
                return commodity;
            }
        }
        return null;
    }
}
