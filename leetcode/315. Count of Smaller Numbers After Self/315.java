package leecoder;

import leetcoder.ListNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int []res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            // 二分
            int l = 0;
            int r = list.size();
            while(l<r){
                int mid = l+ (r-l)/2;
                if(list.get(mid) >= nums[i] ){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            res[i] = l;
            list.add(l,nums[i]);
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}



public class Main {
    public static void main(String[] args) {
        List<Integer> i = new leecoder.Solution().countSmaller(new int[]{5,2,6,1});
        System.out.println(i);
    }
}