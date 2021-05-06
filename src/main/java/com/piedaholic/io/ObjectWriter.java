package com.piedaholic.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;


public class ObjectWriter {

    public static <T> void writeObject(List<? extends Serializable> list, File f) throws IOException {
        if (list.isEmpty()){
            return;
        }
        else {
            try (var out = new ObjectOutputStream(
new BufferedOutputStream(new FileOutputStream(f))
            )){
            for (Object obj : list) {
             out.writeObject(obj);
            }
        }
    }    
}
}