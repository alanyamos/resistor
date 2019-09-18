package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    private Map<String, Band> createBandsMap() {
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

        return bandsMap;
    }

    private Map<Integer, Converter> createConverterMap() {

        Map<Integer, Converter> converterMap = new HashMap<>();
        converterMap.put(3, new ThreeBandsConverter());
        converterMap.put(4, new FourBandsConverter());
        converterMap.put(5, new FiveBandsConverter());

        return converterMap;
    }

    @Test
    public void shouldReturnAValueWithTwoDigitsDifferentFromZeroAndTolerance() {

        String[] colors = {"blue", "grey", "black", "gold"};

        Map<String, Band> bandsMap = createBandsMap();

        Map<Integer, Converter> converterMap = createConverterMap();

        Converter converter = converterMap.get(colors.length);

        List<Band> bands = converter.getSelectedBandsByColors(bandsMap, colors);

        String expected = converter.bandsToNumericValue(bands);

        assertThat(expected, is("68 ohms 5%"));
    }


    @Test
    public void shouldReturnAValueWithTwoDigitsDifferentFromZeroAndDefaultTolerance() {

        String[] colors = {"blue", "grey", "black"};

        Map<String, Band> bandsMap = createBandsMap();

        Map<Integer, Converter> converterMap = createConverterMap();

        Converter converter = converterMap.get(colors.length);

        List<Band> bands = converter.getSelectedBandsByColors(bandsMap, colors);

        String expected = converter.bandsToNumericValue(bands);

        assertThat(expected, is("68 ohms 20%"));
    }

    @Test
    public void shouldReturnAValueWithThreeDigitsDifferentFromZeroAndTolerance() {

        String[] colors = {"blue", "grey", "yellow", "orange", "brown"};

        Map<String, Band> bandsMap = createBandsMap();

        Map<Integer, Converter> converterMap = createConverterMap();

        Converter converter = converterMap.get(colors.length);

        List<Band> bands = converter.getSelectedBandsByColors(bandsMap, colors);

        String expected = converter.bandsToNumericValue(bands);

        assertThat(expected, is("684000 ohms 1%"));
    }

    @Test
    public void shouldReturnAValueWithThreeDigitsDifferentFromZeroAndDefaultTolerance() {

        String[] colors = {"blue", "grey", "yellow", "orange"};

        Map<String, Band> bandsMap = createBandsMap();

        Map<Integer, Converter> converterMap = createConverterMap();

        Converter converter = converterMap.get(colors.length);

        List<Band> bands = converter.getSelectedBandsByColors(bandsMap, colors);

        String expected = converter.bandsToNumericValue(bands);

        assertThat(expected, is("684000 ohms 20%"));
    }
}



