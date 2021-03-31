package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;





class Solution {
    public int majorityElement(int[] nums) {
        int n = 0; int size =0;
        for (int i = 0; i+1 < nums.length; i+=2) {
            if(nums[i]!=nums[i+1]){
                continue;
            }else{
                if(size > 0){
                    if(nums[i] == n)
                        size++;
                    else size --;
                }else{
                    size ++ ;
                    n = nums[i];
                }
            }
        }
        if(size == 0 ){
            return nums[nums.length-1];
        }else {
            return n;
        }
    }
}

public class Main {

    public static void main(String[] arg){






    }

}