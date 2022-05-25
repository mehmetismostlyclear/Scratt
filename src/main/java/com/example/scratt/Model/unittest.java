package com.example.scratt.Model;

import java.io.FileNotFoundException;

public class unittest {
    public static void main(String[] args) throws FileNotFoundException {
        WordList wd = new WordList();
        wd.getListFromTextFile("C:/Users/mkurn/Desktop/New folder/src/main/resources/turkishwordlist.txt");

    }
}
