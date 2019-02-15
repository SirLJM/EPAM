package com.company;


import javax.activation.MimetypesFileTypeMap;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\temp\\4.gif");
        System.out.println(getMagicNumber(file));
        System.out.println(getFileExtension(file));
        comparator(file);
    }

    public static String getFileExtension(File file) {
        if (file == null) {
            throw new NullPointerException("File argument was null");
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }

    public static String getMagicNumber(File file) {
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mime = mimeTypesMap.getContentType(file);
        if (mime.contains("jpg") || mime.contains("jpeg")) {
            mime = "jpg";
        } else if (mime.contains("txt") || mime.contains("text")) {
            mime = "txt";
        } else if (mime.contains("gif")) {
            mime = "gif";
        }

        return mime;
    }

    public static void comparator(File file) {
        if (getMagicNumber(file).equals(getFileExtension(file))) {
            System.out.println("File type is correct");
        } else {
            System.out.println("Extension is " + getFileExtension(file) + ", while actually it's a " + getMagicNumber(file));
        }
    }

}
