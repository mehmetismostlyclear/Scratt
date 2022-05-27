package com.example.scratt.Services;

import com.example.scratt.Model.Letters;
import com.example.scratt.Model.WordList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class CreateGame {
    private int i = 0;
    ArrayList<String> gamewords = new ArrayList<String>();
    ArrayList<String> gamewordswithcenterletter = new ArrayList<String>();
    Letters lt = new Letters();
    public void generateRandomLetters() throws FileNotFoundException {
        Random random = new Random();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (i = 0; i < 7; i++) {
            nums.add(random.nextInt(0, 30));
            nums = removeDuplicates(nums);
        }
        if(isitWorhtitToPlay(nums))
            gamewordswithcenterletter = choosecenterletterandwords(gamewords, nums);
        else
            generateRandomLetters();
    }
    ///bu metot bir listedeki aynı integer değerleri dışarı atar içeiçe metot şeklinde yazılması daha doğru
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        i--; /// bura yanlış
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
    /// karışık numaralı listeden kaç tane kelime sözlüğün içinde mi?
    public boolean isitWorhtitToPlay (ArrayList<Integer> randomnums) throws FileNotFoundException {
        StringBuilder gameletters = new StringBuilder();
        ArrayList<String> dictinoary ;
        int cout = 0;
        for (int randomnum : randomnums){
            gameletters.append(lt.numbersMap.get(randomnum));
        }
        WordList wd = new WordList();
        wd.getListFromTextFile("path");
        dictinoary = wd.getDictinoary();

        for(String word : dictinoary){
            int wordsnumber = 0;
                for (int i = 0; i < 7; i++){
                    if(word.contains(String.valueOf(gameletters.charAt(i))))
                        cout++;
                    }
            if (cout > 3) gamewords.add(word);
        }
        /// burayı da soralım
        return gamewords.size() > 7;
    }
    public ArrayList<String> choosecenterletterandwords(ArrayList<String> gamewords, ArrayList<Integer> nums){
        int max = 0;
        char centerLetter = 'a';
        for(int randomnum : nums){
            char S = lt.numbersMap.get(randomnum);
            int newmax = Collections.frequency(gamewords, S);
            if(newmax > max)
                max = newmax;
                centerLetter = S;
        }
        final char CenterLetter = centerLetter;
        gamewords.removeIf(n -> n.contains(String.valueOf(CenterLetter)));
        return gamewords;
    }
}






