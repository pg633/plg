package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;
import sun.security.x509.AttributeNameEnumeration;

import javax.swing.*;
import java.util.*;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(n1 > nums[i]){
                n1 = nums[i];
            }else {
                if(n2 > nums[i]){
                    n2 = nums[i];
                }else {
                    return true;
                }
            }

        }
        return false;
    }
}





public class Main {
    public static void main(String[] args) {


    }
}