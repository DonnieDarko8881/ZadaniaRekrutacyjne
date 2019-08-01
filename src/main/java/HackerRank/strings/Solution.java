package HackerRank.strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char letterA : a.toCharArray()) {
            if (map.containsKey(letterA)) {
                map.put(letterA, map.get(letterA) + 1);
            } else {
                map.put(letterA, 1);
            }
        }

        for (char letterB : b.toCharArray()) {
           if(map.containsKey(letterB)){
               int amount = map.get(letterB);
               if(amount==1){
                   map.remove(letterB);
               }else{
                   map.put(letterB, amount -1);
               }
           }else {
               count++;
           }
        }
        for (Integer i:map.values()) {
            count+=i;
        }
        return count;
    }

//    Druga gorsza metoda
    static int makeAnagram1(String a, String b) {
        Map<Character, Integer> letterFreqA = new HashMap<>();
        Map<Character, Integer> letterFreqB = new HashMap<>();
        int count = 0;

        for (char letterA : a.toCharArray()) {
            if (letterFreqA.containsKey(letterA)) {
                letterFreqA.put(letterA, letterFreqA.get(letterA) + 1);
            } else {
                letterFreqA.put(letterA, 1);
            }
        }

        for (char letterB : b.toCharArray()) {
            if (letterFreqB.containsKey(letterB)) {
                letterFreqB.put(letterB, letterFreqB.get(letterB) + 1);
            } else {
                letterFreqB.put(letterB, 1);
            }
        }

        for (int i = 0; i < 26; i++) {
            int liczba = 97 + i;
            char let = (char) liczba;
            if (letterFreqA.get(let) != (letterFreqB.get(let))) {
                if (letterFreqA.get(let) != null && letterFreqB.get(let) != null) {

                    count += Math.abs(letterFreqA.get(let) - letterFreqB.get(let));
                } else if (letterFreqA.get(let) != null && letterFreqB.get(let) == null) {
                    count += 1 * letterFreqA.get(let);
                } else if (letterFreqA.get(let) == null && letterFreqB.get(let) != null) {
                    count += 1 * letterFreqB.get(let);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = makeAnagram("cde", "abc");
        System.out.println(i);
    }
}
