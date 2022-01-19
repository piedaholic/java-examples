package com.piedaholic.models;

import java.io.Serializable;

public class PersonalData implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private Integer age;
    public String sex;
    private String identifier;
    private String identifierType;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String zipCode;
    private String province;
    private String country;

    private PersonalData() {
    }

    // Only accessible within this class
    /*-
    private PersonalData(String name, Integer age, String sex, String identifier, String identifierType) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.identifier = identifier;
        this.identifierType = identifierType;
    }
    */

    // Only accessible within this package
    protected PersonalData(String name, Integer age, String sex, String identifier, String identifierType,
            String country, String zipCode) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.country = country;
        this.zipCode = zipCode;
    }

    public PersonalData(String name, Integer age, String sex, String identifier, String identifierType, String country,
            String province, String zipCode) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.country = country;
        this.province = province;
        this.zipCode = zipCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifierType() {
        return this.identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return this.addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Creates a new instance of the class and returns the reference
    public static PersonalData getInstance(){
        return new PersonalData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name : " + this.name + "\n");
        sb.append("Age : " + this.age + "\n");
        sb.append("Sex : " + this.sex + "\n");
        sb.append("Identifier : " + this.identifier + "\n");
        sb.append("Identifier Type : " + this.identifierType + "\n");
        sb.append("Country : " + this.country + "\n");
        sb.append("Province : " + this.province + "\n");
        sb.append("Zip Code : " + this.zipCode + "\n");
        return sb.toString();
    }

}
