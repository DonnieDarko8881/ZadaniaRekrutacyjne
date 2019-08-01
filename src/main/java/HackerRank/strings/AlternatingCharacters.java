package HackerRank.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        List<Character> characterList = new ArrayList<>();
        int count = 0;

        for (char c : chars) {
            characterList.add(c);
        }

        for (int i = 0; i+1 < characterList.size(); i++) {
            if (characterList.get(i) == characterList.get(i + 1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int count = alternatingCharacters("AAABBB");
        System.out.println(count);

    }
}
