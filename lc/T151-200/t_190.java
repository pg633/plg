package leetcoder;

import javax.xml.transform.SourceLocator;
import java.util.*;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}

public class Main {

    public static void main(String[] arg) {
        int i = new Solution().reverseBits(43261596);
        System.out.println(i);
    }

}