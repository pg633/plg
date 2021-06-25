package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i+1;
                    res[1] = j+1;
                    return res;
                }
            }
        }
        return res;
    }
}



public class Main {

    public static void main(String[] arg){
    }

}