package HackerRank.hashmap.sherlokAndAnagrams;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {



    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> anagrams = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String substring = s.substring(j, j + i + 1);
                String substringSorted = Stream.of(substring.split(""))
                        .sorted().collect(Collectors.joining());

                if (!anagrams.containsKey(substringSorted)) {
                    anagrams.put(substringSorted, 1);
                } else {
                    anagrams.put(substringSorted, anagrams.get(substringSorted) + 1);
                }
            }
        }

        return anagrams.entrySet().stream()
                .filter(substring -> substring.getValue() > 1)
                .map(Map.Entry::getValue)
                .map(value -> value*(value-1)/2)
                .mapToInt(value -> value.intValue())
                .sum();
    }

    public static void main(String[] args) {
        String cosik = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(sherlockAndAnagrams(cosik));
    }
}
