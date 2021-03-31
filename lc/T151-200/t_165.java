package leetcoder;

import java.util.Arrays;

class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2))return 0;
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length,s2.length);
        for (int i = 0; i < n; i++) {
            int n1 = 0;
            int n2 = 0;
            if(s1.length > i ){
                n1 = Integer.valueOf(s1[i]);
            }
            if(s2.length > i ){
                n2 = Integer.valueOf(s2[i]);
            }
            if(n1 > n2)return 1;
            if(n1 < n2)return -1;
        }
        return 0;

    }
}



public class Main {

    public static void main(String[] arg){
        int i = new Solution().compareVersion("0.1", "1.1");
        System.out.println(i);
    }

}