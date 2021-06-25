package leetcoder;


import java.util.*;
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length == 0){
            return false;
        }


        int flag = 0;
        for(int z = 1 ; z < nums.length ; z++){
            if( Math.abs(nums[z]) < Math.abs(nums[z-1]) ){
                flag = 1;
                break;
            }
        }
        if(flag == 0){

            return false;
        }
        HashSet set = new HashSet();
        for(int i = 0; i < nums.length - 2; i++){

            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            for(int k = i + 1; k < nums.length; k++){
                if(nums[k] - nums[i] < 1){
                    continue;
                }
                for(int j = i + 1; j < k; j++){
                    if(nums[j] > nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}



public class AAA {
    public static void main(String[] args) {


    }
}