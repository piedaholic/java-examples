package com.piedaholic.examples;

import java.util.ArrayList;

public class StringExamples {

    public static final String str = "Hello World! I am Harsh Prakash Singh.";

    public static void main(String... args) {
        reference_examples();
        // string_trim_funcs();
        // string_compare_funcs();
        // Java String Index starts at 0
        string_concat_examples();
        string_other_funcs();
    }

    public static void string_concat_examples() {
        String str = "Hello Harsh!";
        str.concat("Lets do some string concatenation!"); // Will not be concatenated
        System.out.println(str);
        // A String is immutable. Calling concat() returns a new String but does not
        // change the original.
        str = str.concat("Lets do some string concatenation!"); // Will be concatenated this time
        System.out.println(str);
        str += 123;
        System.out.println(str);
        str += false;
        System.out.println(str);
        str += 'c';
        System.out.println(str);

        String s1 = "purr";
        String s2 = "";
        // Remember String objects are immutable
        s1.toUpperCase(); // "PURR" is returned but not stored
        s1.trim(); // "purr" is returned but not stored
        s1.substring(1, 3); // "ur" is returned but not stored
        s1 += "two"; // Finally "two" is appended to "purr" // "purrtwo"

        // Remember a String concatenated with any other type gives a String
        s2 += 2;
        s2 += 'c';
        s2 += false;

        if (s2 == "2cfalse")
            System.out.println("=="); // Te two String objects are not the same in memory. One comes directly from
                                      // the string pool, and the other comes from building using String operations
        if (s2.equals("2cfalse"))
            System.out.println("equals"); // Holds true because of object equality
        System.out.println(s1.length());
    }

    public static void reference_examples() {
        String str1 = "piedaholic";
        String str2 = "piedaholic";

        System.out.println("*****Block 1*****");
        System.out.println(str1 == str2); // true //Refer the same object in the String pool
        System.out.println(str1.equals(str2)); // true // String values are same

        String str3 = new String("piedaholic");
        String str4 = new String("piedaholic");
        String str5 = new String(str1);

        System.out.println("*****Block 2*****");
        System.out.println(str3 == str4); // false
        System.out.println(str3.equals(str4)); // true

        System.out.println("*****Block 3*****");
        System.out.println(str1 == str3); // false
        System.out.println(str1.equals(str3)); // true
        System.out.println(str1 == str5); // false
        System.out.println(str1.equals(str5)); // true
        System.out.println(str3 == str5); // false
        System.out.println(str3.equals(str5)); // true

        System.out.println("*****Block 4*****");
        System.out.println(str1 == str3.intern()); // true
        // System.out.println(str1.equals(str3.intern())); // true
        System.out.println(str1 == str5.intern()); // true
        // System.out.println(str1.equals(str5.intern())); // true
        System.out.println(str3 == str5.intern()); // false
        System.out.println(str3.intern() == str5.intern()); // true
        // System.out.println(str3.equals(str5.intern())); // true
        System.out.println(str4 == str5.intern()); // false
        System.out.println(str4.intern() == str5.intern()); // true

        String str6 = new String("piedaholic").intern();
        String str7 = new String(str1).intern();

        System.out.println("*****Block 5*****");
        System.out.println(str1 == str6); // true
        System.out.println(str1.equals(str6)); // true
        System.out.println(str1 == str7); // true
        System.out.println(str1.equals(str7)); // true

        var str8 = "piedaholic";
        var str9 = new String(str8);
        var str10 = new String("piedaholic");

        System.out.println("*****Block 6*****");
        System.out.println(str8 == str9); // false
        System.out.println(str8.equals(str9)); // true
        System.out.println(str8 == str9.intern()); // true
        // System.out.println(str8.equals(str9.intern())); // true
        System.out.println(str8 == str10.intern()); // true
        // System.out.println(str8.equals(str10.intern())); // true
    }

    public static void string_trim_funcs() {
        String str = "\r\n\tHarsh\t\r\n";
        System.out.println(str);
        // trim()
        System.out.println(str.trim()); // All whitespace characters removed

        // strip()
        System.out.println(str.strip());
        System.out.println(str.stripTrailing());
        System.out.println(str.stripLeading());
    }

    public static void string_compare_funcs() {
        String str1 = "Hello World";
        String str2 = "Hello World";
        System.out.println(str1.compareTo(str2)); // If strings are equal, 0 is returned
        String str3 = "Hello World Harsh";
        System.out.println(str1.compareTo(str3)); // If first string
    }

    public static void string_other_funcs() {
        System.out.println(str.charAt(0)); // Character at Index 0

        try {
            System.out.println(str.charAt(100)); // throws exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Inside Exception Block:: " + e.getMessage());
        }

        System.out.println(str.substring(0, 4)); // Character at index 4 excluded
        try {
            System.out.println(str.substring(6, 5)); // throws exception
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(str.substring(1, 1));
        System.out.println(str.toLowerCase()); // Converts to lowercase
        System.out.println(str.toUpperCase()); // Converts to uppercase

        System.out.println(str.toLowerCase().equalsIgnoreCase(str));
        System.out.println(str.toUpperCase().equalsIgnoreCase(str));

        System.out.println(str.startsWith("H"));
        System.out.println(str.startsWith("h"));
        System.out.println(str.endsWith("."));
        System.out.println(str.endsWith("!"));

        System.out.println(str.replace('H', 'X'));
        System.out.println(str.replaceFirst("H", "X"));
        System.out.println(str.replace("He", "She"));

        System.out.println(str.contains("He")); // Case-Sensitive
        System.out.println(str.contains("She"));
    }

}
