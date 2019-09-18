package com.thoughtworks;

import java.util.List;

public class FourBandsConverter extends Converter {

    String bandsToNumericValue(List<Band> bands) {

        int value = 0;
        String tolerance = "20%";

        Band lastBand = bands.get(bands.size() - 1);
        if(isLastBandTolerance(lastBand)) {
            value = (int) ((bands.get(0).getDigit()*10 + bands.get(1).getDigit())*(Math.pow(10, bands.get(2).getMultiplier())));
            tolerance = bands.get(3).getTolerance();
        } else {
            value = (int) ((bands.get(0).getDigit()*100 + bands.get(1).getDigit()*10 + bands.get(2).getDigit())*(Math.pow(10, bands.get(3).getMultiplier())));
        }

        String result = Integer.toString(value) + " ohms " + tolerance;

        return result;
    }

    private boolean isLastBandTolerance(Band lastBand) {
        boolean isTolerance = true;
        if (lastBand.getTolerance() == null) {
            isTolerance = false;
        }
        return isTolerance;
    }
}
