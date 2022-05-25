package com.example.scratt.Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;


public class CreateGame{
    public void generateRandomLetters()
    {
        Random random = new Random();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < 7; i++) {
            nums.add(random.nextInt());

        }
        removeDuplicates(nums);



    }
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list)
    {

        // Create a new ArrayList
        ArrayList<Integer> newList = new ArrayList<Integer>();

        // Traverse through the first list
        for (Integer element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }
}


