package com.piedaholic.examples;

public class StringBuilderExamples {

    public static void main(String... args) {
        sb_func_examples();
        sb_str_equivalence();
    }

    public static void sb_func_examples() {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb); // prints the string //abbaccca
        System.out.println(sb.toString()); // toString() redundant
        System.out.println(sb.charAt(3)); // a
        sb.replace(0, 1, "A");
        sb.append("DDD", 1, 2);
        System.out.println(sb);
    }

    public static void sb_str_equivalence() {
        String str = "piedaholic";
        StringBuilder sb = new StringBuilder("piedaholic");
        System.out.println(str == sb.toString());
        System.out.println(str.equals(sb.toString()));
    }

}
