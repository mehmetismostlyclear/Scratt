package com.example.scratt.Services;

import com.example.scratt.Model.Letters;
import com.example.scratt.Model.WordList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
public class CreateGameBuilder{
    /*public CreateGame buildGame() throws FileNotFoundException {
        generateRandomLetters();
        return gameletters, gamewordswithcenterletter;

    }*/
    ArrayList<String> gamewords = new ArrayList<String>();
    ArrayList<String> gamewordswithcenterletter = new ArrayList<>();

    Letters lt = new Letters();
    Random random = new Random();
    public StringBuilder gameletters = new StringBuilder();
    public char centerLetter = 'a';

    public CreateGameBuilder() throws FileNotFoundException {
        generateRandomLetters();
    }
    public CreateGameBuilder(StringBuilder gameletters, ArrayList<String> gamewords) throws FileNotFoundException {
        boolean c = false;
        this.gamewords = gamewords;
        this.gameletters = gameletters;
        if(isitWorhtitToPlay(gameletters)){
            c = choosecenterletterandwords(gamewords, lt.ReturnKeyNums(gameletters));
            if(!c){
                ///hatamesajıdönder();
            }
        }
        else{
            ///hata mesajı gönder();
        }
    }


    public void generateRandomLetters() throws FileNotFoundException {
        gameletters.delete(0, 8);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            nums.add(random.nextInt(0, 29));
        }
        nums = removeDuplicates(nums);
        gameletters = lt.ReturnValuesAsAStringBuilder(nums);
        boolean c = false;
        if (isitWorhtitToPlay(gameletters)){
            c = choosecenterletterandwords(gamewords, nums);
            if(!c){
                generateRandomLetters();
            }
        }
        else{
            generateRandomLetters();
        }
    }

    ///bu metot bir listedeki aynı integer değerleri dışarı atar içeiçe metot şeklinde yazılması daha doğru
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
         /// bura yanlış
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
            else{
                newList.add(random.nextInt(0, 29));
                removeDuplicates(newList);
            }
        }
        return newList;
    }

    /// karışık numaralı listeden kaç tane kelime sözlüğün içinde mi?
    public boolean isitWorhtitToPlay (StringBuilder gameletters) throws FileNotFoundException {
        ArrayList<String> dictinoary;
        WordList wd = new WordList();
        wd.getListFromTextFile("C:/Users/mkurn/Desktop/New folder/src/main/resources/VPSOZLUK.txt");
        dictinoary = wd.getDictinoary();
            for (String word : dictinoary) {
                boolean control = true;
                while (control) {
                    int cout = 0;
                    for (int i = 0; i < 7; i++) {
                        if (word.contains(String.valueOf(gameletters.charAt(i)))) {
                            cout++;
                        }
                    }
                    if (cout > 3) {
                        for (char karekter : word.toCharArray()) {
                            if (!gameletters.toString().contains(String.valueOf(karekter))) {
                                control = false;
                                break;
                            }
                        }
                        if (control)
                            gamewords.add(word);
                    }

                    control = false;
                }
            }

        /// burayı da soralım
        if(gamewords.size() > 20){
            return true;
        }
        else
            gameletters.delete(0,8);
        return false;
    }

    public Boolean choosecenterletterandwords(ArrayList<String> gamewords, ArrayList<Integer> nums) throws FileNotFoundException {
        int max = 0;
        for (int randomnum : nums) {
            ArrayList<String> temproarygamewords = new ArrayList<>();
            temproarygamewords.addAll(gamewords);
            centerLetter = lt.numbersMap.get(randomnum);
            temproarygamewords.removeIf(n -> !n.contains((String.valueOf(centerLetter))));
            if (temproarygamewords.size() > 20) {
                gamewordswithcenterletter = new ArrayList<>(temproarygamewords);
                ///buraya bir tane gamelettersstan charı silen kod yazılmalı
                return true;
            }
        }
        return false;
    }
}
