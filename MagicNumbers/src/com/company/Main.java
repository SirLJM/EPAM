package com.company;


import java.io.File;

public class Main {

    public static String getFileExtension(File file) {
        if (file == null) {
            throw new NullPointerException("File argument was null");
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }

    

}
