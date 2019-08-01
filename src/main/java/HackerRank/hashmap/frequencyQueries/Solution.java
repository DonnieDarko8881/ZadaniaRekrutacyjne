package HackerRank.hashmap.frequencyQueries;

import java.util.*;

public class Solution {

    // Complete the freqQuery function below.
    static  List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> dateStructure = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            Integer option = queries.get(i).get(0);
            Integer value = queries.get(i).get(1);
            switch (option) {
                case 1:
                    if (dateStructure.containsKey(value)) {
                        dateStructure.put(value, dateStructure.get(value) + 1);
                    } else {
                        dateStructure.put(value, 1);
                    }
                    break;
                case 2:
                    if (dateStructure.containsKey(value)) {
                        dateStructure.put(value, dateStructure.get(value) - 1);
                        if (dateStructure.get(value).equals(0)) {
                            dateStructure.remove(value);
                        }
                    }
                    break;
                case 3:
                    if (dateStructure.containsValue(value)) {
                        output.add(1);
                    } else {
                        output.add(0);
                    }
                    break;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2));

        List<Integer> ans = freqQuery(queries);

        System.out.println(ans);
    }
}
