package HackerRank.strings;

public class SpecialStringAgain {
    static long substrCount(int n, String s) {
        int length = n;
        long counter = 0;
        for (int i = 0; i < length; i++) {

            int offset = 1;
            while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {
                counter++;
                offset++;
            }

            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
            counter += repeats * (repeats + 1) / 2;
        }
        return counter +length;

    }
    public static void main(String[] args) {

    }


}
