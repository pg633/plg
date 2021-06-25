package leecoder;

import leetcoder.ListNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int bulbSwitch(int n) {
        
        return n<=0? 0: (int )Math.floor(Math.sqrt(n));
    }
}



public class Main {
    public static void main(String[] args) {

        int i = new leecoder.Solution().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
        System.out.println(i);
    }
}