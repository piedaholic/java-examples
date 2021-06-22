package com.piedaholic.enumerations;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class GenderEnumTest {

    @Test
    public void invalidStringValue_ThrowsException() {

    }

    @Test
    public void printGenderEnum_iterateUsingStream() {
        Stream.of(GenderEnum.values()).forEachOrdered(System.out::println);
    }

    @Test
    public void printGenderEnum_iterateUsingEnumSet() {
        EnumSet.allOf(GenderEnum.class).forEach((x) -> System.out.println(x));
    }

    @Test
    public void printGenderEnum_iterate_convertToListUsingArrays() {
        Arrays.asList(GenderEnum.values()).stream().forEach(System.out::println);
    }

    @Test
    public void printGenderEnumValues_convertToListUsingArrays() {
        Arrays.asList(GenderEnum.values()).stream().forEach(x -> System.out.println(x + "~" + x.getValue()));
    }

    @Test
    public void checkCount_GenderEnum() {
        assertEquals(List.of(GenderEnum.values()).stream().count(), 2);
    }

}
