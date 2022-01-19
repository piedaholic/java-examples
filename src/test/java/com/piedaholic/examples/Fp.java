package com.piedaholic.examples;

import java.util.List;
import java.util.ListIterator;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
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
     cons.accept(makeSentence("Hello,", "I", "am", "Harsh"));
     

     BinaryOperator<String> up = String::concat;
     String s1 = up.apply("SREE", "MMM");
    }

    // Predicate Example
    public static boolean isStringEmpty(final String str){
    //Predicate<String> p = String::isEmpty;
    Predicate<String> p = (x) -> x.isEmpty();
    return p.test(str);
    }
    
    // Predicate Example
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

    // Functional Interface Example
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

    public static String makeSentence(String...args){
        List<String> list = List.of(args);
        char sentenceDelimiter = ' ';
        char endOfSentenceMarker = '.';
        StringBuilder sb = new StringBuilder();
        ListIterator<String> li = list.listIterator();
        while (li.hasNext()){
            sb.append(li.next());
            if (li.hasNext()){
               sb.append(sentenceDelimiter); 
            }
        }
        sb.append(endOfSentenceMarker);
        return sb.toString();
        }
    }

