package leecoder;

import leetcoder.ListNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] clone = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                nums[i] = clone[(clone.length-1)/2  - i /2];
            }else{
                nums[i] = clone[clone.length -1  - i /2];
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        int  []a = new int[]{1,1,2,1,2,2,1};
        new leecoder.Solution().wiggleSort(a);
        System.out.println(Arrays.toString(a));




    }
}