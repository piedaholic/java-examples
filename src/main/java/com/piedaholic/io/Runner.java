package com.piedaholic.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.piedaholic.class_design.ClassA;
import com.piedaholic.class_design.PersonalData;
import com.piedaholic.class_design.UserCredentials;

public class Runner {

    public final static String parentDir = "D:\\";

    public static void main(String...args) {
        test_PersonalData();
        try {
            test_UserCredentials();
            test_ClassA(); // Throws java.io.NotSerializableException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test_PersonalData() {
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
            e.printStackTrace();
        }
    }

    public static void test_UserCredentials() throws NotSerializableException, IOException, ClassNotFoundException{
        UserCredentials uc = new UserCredentials("piedaholic", "Harsh", "Prakash", "Singh", "hprakash1911@gmail.com", "ENG");
        List<UserCredentials> li = new ArrayList<>();
        System.out.println("Before Serialization\n" + uc.toString());
        li.add(uc);
        
        for (UserCredentials ucObj : li) {
            File f = new File(parentDir, ucObj.getUserId() + ".txt");
        try(var ou = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
           ou.writeObject(ucObj);
        }
    }
       
    List<Object> objList = new ArrayList<>();
    objList = ObjectReader.readObject(new File(parentDir,"piedaholic.txt"));
    for (Object obj : objList){
        System.out.println(obj.toString());
    }
    }

    public static void test_ClassA() throws IOException {
        ClassA ref = new ClassA(1, "piedaholic");
        ObjectWriter.writeObject(ref, new File(parentDir, "demo.txt"));
    }
    
}
