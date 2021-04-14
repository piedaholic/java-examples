package com.regex;

//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
import java.util.regex.*;

public class RegexChecker {    

    public static void main(String[] args) {
        
        Regex_Test tester = new Regex_Test();
        tester.checker("^[\\d]{1,}$"); //Input the regex pattern here
    }
}

class Regex_Test {

    public void checker(String Regex_Pattern){
        String Test_String = "12345"; //Input the test string here
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }   
    
}