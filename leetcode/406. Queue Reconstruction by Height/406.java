package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people ==null || people.length ==0 || people[0].length ==0) return new int[0][0];

        Arrays.sort(people,(a,b)-> a[0]==b[0]? a[1]-b[1] : b[0]-a[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1],person);
        }
        return  res.toArray(new int[res.size()][])
    }

}

public class AAA {
    public static void main(String[] args) {

    }
}
