package com.piedaholic.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.piedaholic.class_design.PersonalData;

public class Runner {

    public static void main(String...args) {
        PersonalData pd = new PersonalData(
            "Harsh Prakash Singh",27,"M","GEQPS7423B","PAN","IN","BR","800003"
        );
        List<PersonalData> li = new ArrayList<>();
        li.add(pd);
        try
        {ObjectWriter.writeObject(li, new File("D:/Harsh.txt"));}
        catch(IOException io){
            System.err.println(io.getStackTrace());
        };

        li.clear();

        
        try {
            List<Object> objList = new ArrayList<Object>();
            objList = ObjectReader.readObject(new File("D:/Harsh.txt"));
            for (Object obj : objList){
                System.out.println(obj.toString());
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
