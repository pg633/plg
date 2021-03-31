package leetcoder;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0;
        int l2 = 0;
        List<Integer> res = new ArrayList<>();
        while(l1 < nums1.length && l2<nums2.length){
            if(nums1[l1] == nums2[l2]){
                if(!res.contains(nums1[l1]))
                    res.add(nums1[l1]);
                else l1++;
            }else if(nums1[l1] < nums2[l2]){
                l1++;
            }else {
                l2++;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}



public class AAA {
    public static void main(String[] args) {


        int [] list = new Solution().intersection(new int[]{4,1,-1,2,-1,2,3}, new int[]{4,1,-1,2,-1,2,3});
        System.out.println(Arrays.toString(list));
    }
}
