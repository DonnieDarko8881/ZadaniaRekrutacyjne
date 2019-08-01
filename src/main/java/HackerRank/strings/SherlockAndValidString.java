package HackerRank.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    static String isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> mapFreq = new HashMap<>();
        Map<Integer, Integer> freqOfFreq = new HashMap<>();

        for (char a : chars) {
            if (mapFreq.containsKey(a)) {
                mapFreq.put(a, mapFreq.get(a) + 1);
            } else {
                mapFreq.put(a, 1);
            }
        }

        mapFreq.entrySet().forEach(entry -> {
            Integer valueOFmapFreq = entry.getValue();
            if (freqOfFreq.containsKey(valueOFmapFreq)) {
                freqOfFreq.put(valueOFmapFreq, freqOfFreq.get(valueOFmapFreq) + 1);
            } else {
                freqOfFreq.put(valueOFmapFreq, 1);
            }
        });

        long count = freqOfFreq.entrySet().stream()
                .count();
        System.out.println(mapFreq);
        System.out.println(freqOfFreq);

        if (count == 2 && freqOfFreq.containsValue(1)) {
            List<Integer> listOfTwoElement = freqOfFreq.keySet().stream().collect(Collectors.toList());
            if (Math.abs(listOfTwoElement.get(0) - listOfTwoElement.get(1)) == 1) {
                return "YES";
            } else if(freqOfFreq.getOrDefault(1,0)==1){
                return "YES";
            } else{
                return "NO";
            }

        } else if (count == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        String valid = isValid(s);
        System.out.println(valid);

    }
}
