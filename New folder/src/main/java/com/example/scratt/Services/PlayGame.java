package com.example.scratt.Services;

import java.util.ArrayList;

public class PlayGame {
    public boolean checkWord(ArrayList<String> wordswithcenterletter,String userWord){

        Boolean result = false;

        for (String word : wordswithcenterletter){
            if (userWord.matches(word))
                result = true;
        }
        System.out.println(result);
        return result;
    }
}
