package com.thoughtworks;

import java.util.List;

public class FiveBandsConverter extends Converter {

    String bandsToNumericValue(List<Band> bands) {

        int value = (int) ((bands.get(0).getDigit()*100 + bands.get(1).getDigit()*10 + bands.get(2).getDigit())*(Math.pow(10, bands.get(3).getMultiplier())));
        String tolerance = bands.get(4).getTolerance();

        String result = Integer.toString(value) + " ohms " + tolerance;

        return result;
    }
}
