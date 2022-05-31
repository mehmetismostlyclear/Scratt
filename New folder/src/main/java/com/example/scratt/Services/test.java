package com.example.scratt.Services;

import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        CreateGameBuilder cr = new CreateGameBuilder();
        cr.generateRandomLetters();
        System.out.println(cr.centerLetter);
    }
}
