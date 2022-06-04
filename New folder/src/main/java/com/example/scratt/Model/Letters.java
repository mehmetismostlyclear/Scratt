package com.example.scratt.Model;

import java.util.*;
import java.util.stream.Collectors;

public class Letters {
    final char[] letters = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'i', 'ı', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z'};
    public Map<Integer, Character> numbersMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public Letters() {
        for (int i = 0; i < letters.length; i++) {
            numbersMap.put(i, letters[i]);
        }
    }
    public StringBuilder ReturnValuesAsAStringBuilder(ArrayList<Integer> num){
        Letters lt = new Letters();
        for (int randomnum : num) {
            sb.append(lt.numbersMap.get(randomnum));
        }
        return sb;
    }
    public ArrayList<Integer> ReturnKeyNums(StringBuilder SB){
        Letters lt = new Letters();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        class Local {
            Set<Integer> getkeys(
                    Map<Integer, Character> map, Character value) {

                return map
                        .entrySet()
                        .stream()
                        .filter(entry -> Objects.equals(entry.getValue(), value))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());
            }
        }
        for(Integer key : new Local().getkeys(lt.numbersMap, SB.charAt(i))){
            i++;
            arrayList.add(key);
        }
        return arrayList;
    }
}