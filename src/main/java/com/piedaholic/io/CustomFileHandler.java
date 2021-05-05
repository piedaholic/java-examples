package com.piedaholic.io;

import java.io.File;

public class CustomFileHandler {

    public final static String fileSeparator = System.getProperty("file.separator");
    // public final static String fileSeparator = java.io.File.separator;
    
    public boolean create(String path) throws SecurityException{
     File f = new File(path);
     return f.mkdirs();
    }

    public boolean create(File f) throws SecurityException{
        return f.mkdirs();
    }

    public boolean delete(String path) throws SecurityException{
        File f = new File(path);
        return f.delete();
    }

    public boolean delete(File f) throws SecurityException{
        return f.delete();
    }
}
