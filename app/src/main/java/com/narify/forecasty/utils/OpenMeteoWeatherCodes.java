package com.narify.forecasty.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class OpenMeteoWeatherCodes {
    /* Main conditions */
    public final static Set<Integer> CLEAR = new HashSet(Collections.singletonList(0));
    public final static Set<Integer> CLOUDS = new HashSet(Arrays.asList(1, 2, 3));
    public final static Set<Integer> FOG = new HashSet(Arrays.asList(45, 48));
    public final static Set<Integer> DRIZZLE = new HashSet(Arrays.asList(51, 53, 55, 56, 57));
    public final static Set<Integer> RAIN = new HashSet(Arrays.asList(61, 63, 65, 66, 67, 80, 81, 82));
    public final static Set<Integer> SNOW = new HashSet(Arrays.asList(71, 73, 75, 77, 85, 86));
    public final static Set<Integer> THUNDERSTORM = new HashSet(Arrays.asList(95, 96, 99));

    /* Sub condition description keywords */
    public final static Set<Integer> LIGHT = new HashSet(Arrays.asList(1, 51, 56, 61, 71));
    public final static Set<Integer> MODERATE = new HashSet(Arrays.asList(2, 53, 63, 73, 77, 95));
    public final static Set<Integer> HEAVY = new HashSet(Arrays.asList(3, 55, 57, 65, 75));
    public final static Set<Integer> SHOWER = new HashSet(Arrays.asList(80, 81, 82, 85, 86, 96, 99));
    public final static Set<Integer> FREEZING = new HashSet(Arrays.asList(66, 67));
}
