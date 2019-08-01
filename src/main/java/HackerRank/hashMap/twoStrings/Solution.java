package HackerRank.hashMap.twoStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    static String twoStrings(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Set<Character> setChar1 = new HashSet<>();
        Set<Character> setChar2 = new HashSet<>();

        for (char letter:chars1) {
            setChar1.add(letter);
        }
        for (char letter:chars2) {
            setChar2.add(letter);
        }

         setChar1.retainAll(setChar2);
        if(!setChar1.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        String s = twoStrings("abc", "def");
        System.out.println(s);

    }
}
