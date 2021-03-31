package leetcoder;

import javax.xml.transform.SourceLocator;
import java.util.*;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res+=n & 0b1;
            n>>>=1;
        }
        return res;
    }
}

public class Main {

    public static void main(String[] arg) {

    }

}