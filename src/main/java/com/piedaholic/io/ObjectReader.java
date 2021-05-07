package com.piedaholic.io;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectReader {

    public static List<Object> readObject(File f) throws IOException, ClassNotFoundException {
        var objList = new ArrayList<Object>();
        try (ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            while (true) {
                Object obj = oi.readObject();
                objList.add(obj);
            }
        } catch (EOFException e) {
        }
        return objList;
    }

}
