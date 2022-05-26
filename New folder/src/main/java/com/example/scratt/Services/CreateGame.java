package com.example.scratt.Services;

import com.example.scratt.Model.Letters;
import com.example.scratt.Model.WordList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;


public class CreateGame {
    private int i = 0;

    public void generateRandomLetters() {
        Random random = new Random();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (i = 0; i < 7; i++) {
            nums.add(random.nextInt(0, 30));

            nums = removeDuplicates(nums);

        }


    }

    ///bu metot bir listedeki aynı integer değerleri dışarı atar içeiçe metot şeklinde yazılması daha doğru
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        i--;
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer element : list) {
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
        return newList;
    }

    /// karışık numaralı listeden kaç tane kelime sözlüğün içinde ona bakar
    public boolean isitWorhtitToPlay(ArrayList<Integer> randomnums) throws FileNotFoundException {
        ArrayList<String> gameletters = new ArrayList<String>();
        Letters lt = new Letters();
        for (int randomnum : randomnums){
            gameletters.add(String.valueOf(lt.numbersMap.get(randomnum)));
        }
        WordList wd = new WordList();
        wd.getListFromTextFile("path");
        gameletters = wd.getDictinoary();




    }
}






