package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converter {

    List<Band> getSelectedBandsByColors(Map<String, Band> bands, String[] colors) {

        List<Band> selectedBandsByInputColors = new ArrayList<Band>();

        for (String color : colors) {
            Band band = bands.get(color);
            selectedBandsByInputColors.add(band);
        }

        return selectedBandsByInputColors;

    }

    String bandsToNumericValue(List<Band> bands) {

        String tolerance = bands.get(3).getTolerance();
        int value = (int) ((bands.get(0).getDigit()*10 + bands.get(1).getDigit())*(Math.pow(10, bands.get(2).getMultiplier())));

        String result = Integer.toString(value) + " ohms " + tolerance;

        return result;
    }

}
