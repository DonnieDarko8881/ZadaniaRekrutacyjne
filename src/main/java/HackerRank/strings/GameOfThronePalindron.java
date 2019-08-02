package HackerRank.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameOfThronePalindron {
    //better solution
    static String gameOfThrones2(String s) {
        Set<Character> set = new HashSet<Character>();
        for (Character ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        return set.size() <= 1 ? "YES" : "NO";
    }
    //worse solution
    static String gameOfThrones(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapOfFreq = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.entrySet().forEach(entry -> {
            Integer value = entry.getValue();
            if (mapOfFreq.containsKey(value)) {
                mapOfFreq.put(value, mapOfFreq.get(value) + 1);
            } else {
                mapOfFreq.put(value, 1);
            }
        });

        long countOdd = mapOfFreq.entrySet().stream().filter(entry -> entry.getKey() % 2 != 0).count();
        long countAll = mapOfFreq.entrySet().stream().count();
        System.out.println(mapOfFreq);
        if(s.length()%2==0 && countOdd==0){
            return "YES";
        } else if(s.length()%2!=0 && countOdd==1 && countAll!=1){
            return "YES";
        }else {
            return "NO";
        }

    }

    public static void main(String[] args) {
        String s = gameOfThrones("cdefghmnopqrstuvw");
        System.out.println(s);

    }

}
