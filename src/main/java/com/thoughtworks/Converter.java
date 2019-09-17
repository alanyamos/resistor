package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converter {

    String bandsToNumericValue(Map<String, Band> bands, String[] colors) throws NumberOfBandsException {

        int value = 0;
        String tolerance = "";

        List<Band> selectedBandsByInputColors = new ArrayList<Band>();

        for (String color : colors) {
            Band band = bands.get(color);
            selectedBandsByInputColors.add(band);
        }

        int numberOfSelectedBands = selectedBandsByInputColors.size();

        switch(numberOfSelectedBands) {
            case 3:
                value = (int) ((selectedBandsByInputColors.get(0).getDigit()*10 + selectedBandsByInputColors.get(1).getDigit())*(Math.pow(10, selectedBandsByInputColors.get(2).getMultiplier())));
                tolerance = "20%";
                break;
            case 4:
                Band lastBand = selectedBandsByInputColors.get(selectedBandsByInputColors.size() - 1);
                if(isLastBandTolerance(lastBand)) {
                    value = (int) ((selectedBandsByInputColors.get(0).getDigit()*10 + selectedBandsByInputColors.get(1).getDigit())*(Math.pow(10, selectedBandsByInputColors.get(2).getMultiplier())));
                    tolerance = selectedBandsByInputColors.get(3).getTolerance();
                } else {
                    value = (int) ((selectedBandsByInputColors.get(0).getDigit()*100 + selectedBandsByInputColors.get(1).getDigit()*10 + selectedBandsByInputColors.get(2).getDigit())*(Math.pow(10, selectedBandsByInputColors.get(3).getMultiplier())));
                    tolerance = "20%";
                }
                break;
            case 5:
                value = (int) ((selectedBandsByInputColors.get(0).getDigit()*100 + selectedBandsByInputColors.get(1).getDigit()*10 + selectedBandsByInputColors.get(2).getDigit())*(Math.pow(10, selectedBandsByInputColors.get(3).getMultiplier())));
                tolerance = selectedBandsByInputColors.get(4).getTolerance();
                break;
            default:
                throw new NumberOfBandsException();
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
