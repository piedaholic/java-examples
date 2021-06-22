package com.piedaholic.enumerations;

public enum GenderEnum {

    MALE("M"), FEMALE("F");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
