package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreeBandsConverter extends Converter {

    String bandsToNumericValue(List<Band> bands) {

        String tolerance = "20%";
        int value = (int) ((bands.get(0).getDigit()*10 + bands.get(1).getDigit())*(Math.pow(10, bands.get(2).getMultiplier())));

        String result = Integer.toString(value) + " ohms " + tolerance;

        return result;
    }
}
