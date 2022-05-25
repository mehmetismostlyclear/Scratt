package com.example.scratt.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Letters {
    char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 't', 'u', 'ü', 'v', 'y', 'z'};

    char a = letter[2];
    int x = letter.length;

    public void writingahashmap() {
        char[] letters = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'i', 'ı', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z'};
        Map<Integer, Character> numbersMap = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            numbersMap.put(i, letters[i]);
        }
    }
}