package com.example.scratt.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserLetters {
    int uygunKelimeSayisi = 0;
    double puan = 0;
    public ArrayList<String> foundWords = new ArrayList<>();
    public String metin;
    public void play(String metinfromfxml) {
        this.metin = metinfromfxml;
        List<String> letters = new ArrayList<>(metin.length());
        if (isValid(metin)) {
            for (int i = 0; i < metin.length(); i++) {
                String harf = metin.substring(i, i + 1);
                letters.add(harf);
            }
            File file = new File("src/main/resources/VPSOZLUK.txt");

            // list that holds strings of a file
            ArrayList<String> listOfStrings = new ArrayList<String>();

            // load data from file
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // read entire line as string
            String line = null;
            try {
                line = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // checking for end of file
            while (line != null) {
                listOfStrings.add(line);
                try {
                    line = bf.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // closing bufferreader object
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            findWord(listOfStrings, letters);

            System.out.println("Bu harflerle yazılabilecek kelime sayısı : " + uygunKelimeSayisi);
            System.out.println("Oluşan bu kelimelerin toplam puanı : " + findTotalPoint(foundWords));
        } else {
            System.out.println("geçersizz");
            ///play();
            }

        // storing the data in arraylist to array
        /*for (int i = 0; i < listOfStrings.size(); i++) {
            System.out.println(listOfStrings.get(i));
        }*/



    }
    public boolean isValid(String usersLetters) {
        boolean result = true;
        StringBuilder letters = new StringBuilder(usersLetters);

        ArrayList<String> vowels = new ArrayList<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("ı");
        vowels.add("i");
        vowels.add("o");
        vowels.add("ö");
        vowels.add("u");
        vowels.add("ü");

        String regex = " ";

        if (usersLetters.length() != 7)
            result = false;
        if (usersLetters.contains("q") || usersLetters.contains("w") || usersLetters.contains("x"))
            result = false;

        /*for (int i = 0; i < vowels.size(); i++) {
            if(!usersLetters.contains(vowels.get(i))) {
                result = false;
            }
        }*/

        for (int i = 0; i < 7; i++) {

            for (int j = i + 1; j < 7; j++) {

                if (usersLetters.charAt(i) == usersLetters.charAt(j))
                    result = false;

            }
            if (!Character.isLetter(usersLetters.charAt(i)))
                result = false;
        }

        //isPangram(foundWords,usersLetters);

        return result;
    }

    //asdfcvb

    // Function to print the words1
    public void printWord(String matchingWord, String targetWord) {

        for (int i = 0; i < matchingWord.length(); i++) {
            if (targetWord.indexOf(matchingWord.charAt(i)) < 0) {
                //System.out.println("Kelimede bu harf yok" + matchingWord);
                return;
            }
        }
        if (matchingWord.length() >= 4) {
            System.out.println(matchingWord);
            uygunKelimeSayisi++;
            foundWords.add(matchingWord);
        }

    }
    public double findTotalPoint(ArrayList<String> foundWord) {

        for (int i = 0; i < uygunKelimeSayisi; i++) {
            if (foundWord.get(i).length() == 4) {
                puan += 1;
            } else if (foundWord.get(i).length() >= 4) {
                puan += (foundWord.get(i).length() - 4) * 2;
            }
        }
        return puan;
    }
    /*public boolean isPangram(ArrayList<String> foundWords1,String usersLetters) {
        boolean result = true;
        for (int i = 0; i < foundWords1.size(); i++) {
            if(!foundWords1.get(i).contains(usersLetters)) {
                System.out.println("Bu harflerle oluşabilecek pangram bir kelime yok.");
                result = false;
            }
        }
        return result;
    }*/
    // Function to find the words
    public void findWord(ArrayList<String> dictionaryWords, List<String> userLetters) {
        String userWord = "";
        for (String userLetter : userLetters) {
            userWord += userLetter;
        }
        for (int i = 0; i < dictionaryWords.size(); i++) {
            printWord(dictionaryWords.get(i), userWord);
        }
    }
}


