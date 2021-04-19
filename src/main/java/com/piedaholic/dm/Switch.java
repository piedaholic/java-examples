package com.piedaholic.dm;

public class Switch {
    final int getCookies() {
        return 4;
    }

    void feedAnimals() {
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch (numberOfAnimals) {
        case bananas:
            System.out.println(bananas);
            break;
        // case apples: System.out.println(apples);// DOES NOT COMPILES
        // case getCookies(): System.out.println(getCookies());// DOES NOT COMPILE
        // case cookies: System.out.println(cookies);// DOES NOT COMPILE
        // Methods are not evaluated until runtime, so they cannot be used as the value
        // of a case statement, even if one of the values is stored in a final variable
        case 3 * 5:
            System.out.println("Hello!");
            break;
        default:
            System.out.println("Hello World!");
            break;
        }
    }

}
