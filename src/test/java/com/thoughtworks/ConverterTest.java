package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    private Converter converter = new Converter();

    private Map<String, Band> createBandsMap() {
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

        return bands;
    }

    @Test
    public void shouldReturnAValueWithTwoDigitsDifferentFromZeroAndTolerance() throws NumberOfBandsException {

        String[] colors = {"blue", "grey", "black", "gold"};

        Map<String, Band> bands = createBandsMap();

        String expected = converter.bandsToNumericValue(bands, colors);

        assertThat(expected, is("68 ohms 5%"));
    }


    @Test
    public void shouldReturnAValueWithTwoDigitsDifferentFromZeroAndDefaultTolerance() throws NumberOfBandsException {

        String[] colors = {"blue", "grey", "black"};

        Map<String, Band> bands = createBandsMap();

        String expected = converter.bandsToNumericValue(bands, colors);

        assertThat(expected, is("68 ohms 20%"));
    }

    @Test
    public void shouldReturnAValueWithThreeDigitsDifferentFromZeroAndTolerance() throws NumberOfBandsException {

        String[] colors = {"blue", "grey", "yellow", "orange", "brown"};

        Map<String, Band> bands = createBandsMap();

        String expected = converter.bandsToNumericValue(bands, colors);

        assertThat(expected, is("684000 ohms 1%"));
    }

    @Test
    public void shouldReturnAValueWithThreeDigitsDifferentFromZeroAndDefaultTolerance() throws NumberOfBandsException {

        String[] colors = {"blue", "grey", "yellow", "orange"};

        Map<String, Band> bands = createBandsMap();

        String expected = converter.bandsToNumericValue(bands, colors);

        assertThat(expected, is("684000 ohms 20%"));
    }
}



