package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;





//
//    1 -> A
//            2 -> B
//            3 -> C
//            ...
//            26 -> Z
//            27 -> AA
//            28 -> AB



class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            n--;
            int now = n%26;
            n/=26;

            sb.append( (char)('A'+now) );
        }
        return  sb.reverse().toString();
    }
}


public class Main {

    public static void main(String[] arg){
        String s = new Solution().convertToTitle(28);
        System.out.println(s);
    }

}