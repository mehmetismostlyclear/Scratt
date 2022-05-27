package com.example.scratt.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Letters {
    final char[] letters = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'i', 'ı', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z'};
    public Map<Integer, Character> numbersMap = new HashMap<>();
    public Letters() {
        for (int i = 0; i < letters.length; i++) {
            numbersMap.put(i, letters[i]);
        }
    }
}