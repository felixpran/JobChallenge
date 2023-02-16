package main.services;

import main.enums.Commodity;
import main.enums.RomanNumerals;

import java.util.HashMap;
import java.util.Map;

public class MapManager {

    // TODO: Think - should this be a singleton class
    private static MapManager mapManager = new MapManager();

    private Map<String, RomanNumerals> unitToRomanNumeralMap;
    private Map<Commodity, Integer> commodityToCreditMap;

    private MapManager() {
        this.unitToRomanNumeralMap = new HashMap<>();
        this.commodityToCreditMap = new HashMap<>();
    }

    public static MapManager getInstance(){
        return mapManager;
    }

    public void addUnitToRomanNumeralEntry(String key, RomanNumerals value) {
        unitToRomanNumeralMap.put(key, value);
    }

    public void addCommodityToCreditEntry(Commodity key, Integer value) {
        commodityToCreditMap.put(key, value);
    }

    public Map<Commodity, Integer> getCommodityToCreditMap() {
        return commodityToCreditMap;
    }

    public Map<String, RomanNumerals> getUnitToRomanNumeralMap() {
        return unitToRomanNumeralMap;
    }

    public RomanNumerals getRomanNumeralByUnit(String unit){
        return unitToRomanNumeralMap.get(unit);
    }

    public Integer getCreditByCommodity(Commodity commodity){
        return commodityToCreditMap.get(commodity);
    }
}
