package com.thoughtworks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String args[]) throws NumberOfBandsException{

        String[] colors = {"blue", "grey", "black", "gold"};

        Map<String, Band> bandsMap = new HashMap<>();
        bandsMap.put("black", new Band(0,0,null));
        bandsMap.put("brown", new Band(1,1,"1%"));
        bandsMap.put("red", new Band(2,2,"2%"));
        bandsMap.put("orange", new Band(3,3,null));
        bandsMap.put("yellow", new Band(4,4,null));
        bandsMap.put("green", new Band(5,5,"0.5%"));
        bandsMap.put("blue", new Band(6,6,null));
        bandsMap.put("violet", new Band(7,7,null));
        bandsMap.put("grey", new Band(8,-1,null));
        bandsMap.put("white", new Band(9,-1,null));
        bandsMap.put("gold", new Band(-1,-1,"5%"));
        bandsMap.put("silver", new Band(-1,-1,"10%"));

        Map<Integer, Converter> converterMap = new HashMap<>();
        converterMap.put(3, new ThreeBandsConverter());
        converterMap.put(4, new FourBandsConverter());
        converterMap.put(5, new FiveBandsConverter());

        Converter converter = converterMap.get(colors.length);

        List<Band> bands = converter.getSelectedBandsByColors(bandsMap, colors);

        String numericValue = converter.bandsToNumericValue(bands);

        System.out.println(numericValue);
    }

}
