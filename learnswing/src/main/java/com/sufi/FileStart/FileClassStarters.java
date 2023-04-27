package com.sufi.FileStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileClassStarters {
    String path;

    public FileClassStarters(String path) {
        this.path = path;
    }

    public static void main(String[] args) {

        // Create a file
        File myFile = new File("C:\\Users\\diurno\\Desktop\\myFile.txt");
        try {
            FileOutputStream fos = new FileOutputStream(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
