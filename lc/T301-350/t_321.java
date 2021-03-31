package leecoder;

import leetcoder.ListNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;



class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int []max = null;
        for (int i = 0; i<=k && i <= nums1.length;i++) {
            int j = k-i;
            if(j  > nums2.length || j<0) continue;
            int [] res1 = getMax(nums1,i);
            int [] res2 = getMax(nums2,j);
            int [] res3 =  merge(res1,res2);
            if(max == null || !greater(max,res3,0,0)) max = res3;
        }
        return max;
    }

    public int[] merge(int[] res1, int[] res2) {
        int [] res = new int[res1.length + res2.length];
        int i=0;int j =0;
        for (int k = 0; k < res.length; k++) {
            res[k] = greater(res1,res2,i,j) ? res1[i++]:res2[j++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int[] nums2,int i,int j) {
        while(i<nums1.length&&j<nums2.length&&nums1[i]==nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length||(i<nums1.length&&nums1[i]>nums2[j]);


    }
    public int[] getMax(int[] nums2, int j) {
        int [] res = new int[j];
        int index = 0 ;

        for (int i = 0; i < nums2.length; i++) {
            while(index > 0 && ( nums2.length - i > j - index && res[index-1] < nums2[i]))
                index --;
            if(index < j){
                res[index++] = nums2[i];
            }
        }
        return  res;
    }
}





public class Main {
    public static void main(String[] args) {


//        int[] max = new Solution().getMax(new int[]{3, 4, 6, 5}, 1);
//        System.out.println(Arrays.toString(max));


        int[] ints = new leecoder.Solution().maxNumber(null, new int[]{1},1);
        System.out.println(Arrays.toString(ints));

//
//        int[] merge = new Solution().merge(new int[]{3, 4, 6}, new int[]{9, 1, 2});
//        System.out.println(Arrays.toString(merge));


    }
}