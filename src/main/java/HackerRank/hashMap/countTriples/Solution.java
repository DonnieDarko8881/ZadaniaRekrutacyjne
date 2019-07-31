package HackerRank.hashMap.countTriples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();
        long counter = 0;

        for (Long a:arr) {
            counter += t3.getOrDefault(a,0l);
            if(t2.containsKey(a)){
                t3.put(a*r,t3.getOrDefault(a*r,0l)+ t2.get(a));
            }
            t2.put(a*r,t2.getOrDefault(a,0l)+1);
        }
        return counter;
    }

    public static void main(String[] args) {
        List<Long> arr = Arrays.asList(1l,2l,2l,4l,4l,4l);
        long countTriplets = countTriplets(arr, 2l);
        System.out.println(countTriplets);
    }
}
