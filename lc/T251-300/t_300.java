package leetcoder;

import DateStruct.Alg.max;
import org.apache.commons.collections.map.HashedMap;
import sun.jvm.hotspot.tools.soql.SOQL;

import javax.print.attribute.standard.PrinterResolution;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);

                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}



public class Main {

    public static void main(String[] arg) {



    }

}

