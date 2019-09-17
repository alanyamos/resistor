package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String args[]) throws NumberOfBandsException{

        String[] colors = {"blue", "grey", "black", "gold"};

        Map<String, Band> bands = new HashMap<>();
        bands.put("black", new Band(0,0,null));
        bands.put("brown", new Band(1,1,"1%"));
        bands.put("red", new Band(2,2,"2%"));
        bands.put("orange", new Band(3,3,null));
        bands.put("yellow", new Band(4,4,null));
        bands.put("green", new Band(5,5,"0.5%"));
        bands.put("blue", new Band(6,6,null));
        bands.put("violet", new Band(7,7,null));
        bands.put("grey", new Band(8,-1,null));
        bands.put("white", new Band(9,-1,null));
        bands.put("gold", new Band(-1,-1,"5%"));
        bands.put("silver", new Band(-1,-1,"10%"));

        Converter converter = new Converter();

        String numericValue = converter.bandsToNumericValue(bands, colors);

        System.out.println(numericValue);
    }

}
