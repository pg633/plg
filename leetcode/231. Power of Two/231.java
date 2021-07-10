package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        if((n & (n-1)) ==0) return true;
        return false;

    }
}

public class Main {

    public static void main(String[] arg) {
    }

}