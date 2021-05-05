package com.piedaholic.examples;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.piedaholic.fp.TriFunction;


public class Fp {

    public static void main(String...args){
     //Consumer<Object> cons = System.out::println;
     Consumer<Object> cons = (x) -> System.out.println(x);
     cons.accept(isStringEmpty("     ")); // false
     //cons.accept(isStringEmpty(null)); // Throws NullPointerException
     cons.accept(isStringEmpty("")); // true
     cons.accept(isStringEmpty("\t\n\r")); // false
     cons.accept(isStringBlank("     ")); // true
     cons.accept(isStringBlank("")); // true
     cons.accept(isStringBlank("\t\n\r"));// true
     //cons.accept(isStringBlank(null));// Throws NullPointerException
     cons.accept(makeSentence("Hi", "I", "Harsh"));
     
    }

    public static boolean isStringEmpty(final String str){
    //Predicate<String> p = String::isEmpty;
    Predicate<String> p = (x) -> x.isEmpty();
    return p.test(str);
    }

    //Checks if a String is whitespace, empty ("") or null.
    public static boolean isStringBlank(final String str){
        //Predicate<String> p = String::isEmpty;
        Predicate<String> p = (x) -> x.isBlank();
        return p.test(str);
        }

    public static boolean areStringsEqual(final String str1, final String str2){
     //BiPredicate <String,String> p = String::equals;   
     BiPredicate<String,String> p = (x,y) -> x.equals(y);
     return p.test(str1, str2);
    }

    public static String makeSentence(String str1, String str2, String str3){
        TriFunction<String,String,String, String> tri = (x,y,z) -> {
            String result = x;
            char sentenceDelimiter = ' ';
            char endOfSentenceMarker = '.';
            result += sentenceDelimiter;
            result = result.concat(y);
             result += sentenceDelimiter;
             result = result.concat(z);
             result += endOfSentenceMarker;
             return result;
          };
     return tri.apply(str1, str2, str3);
    }
    
    
}
