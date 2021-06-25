package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;
import sun.security.x509.AttributeNameEnumeration;

import javax.swing.*;
import java.util.*;


class Solution {
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if(x[i-1]<=x[i-3] && x[i] >= x[i-2]) return true;
            if(i>=4 && x[i-1] == x[i-3] && x[i-2] <= x[i] +x[i-4]) return true;
            if(i>=5 && x[i-2] >= x[i-4] && x[i-3] >=x[i-1]
                    && x[i-1] + x[i-5] >=x[i-3] && x[i]+x[i-4] >=x[i-2]) return true;

        }
        return false;
    }
}



public class Main {
    public static void main(String[] args) {


    }
}