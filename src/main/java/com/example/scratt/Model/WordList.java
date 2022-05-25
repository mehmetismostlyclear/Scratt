package com.example.scratt.Model;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class WordList {
    private ArrayList<String> words = new ArrayList<String>();

    public void getListFromTextFile(String path) throws FileNotFoundException {
        File sourceFile = new File(path);
        if (!sourceFile.exists())
            System.out.println("source file dosnt exists");
        try (Scanner scanner = new Scanner(sourceFile)) {
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                words.add(word);
            }
        }
    }



}
