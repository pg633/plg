package leecoder;

import leetcoder.ListNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n%3!=0)return false;
        return isPowerOfThree(n/3);
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println(new leecoder.Solution().isPowerOfThree(27));

    }
}