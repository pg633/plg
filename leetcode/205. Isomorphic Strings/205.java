package leetcoder;

import java.util.ArrayList;
import java.util.List;


/**
 * can use find position
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if((s.charAt(i)== s.charAt(j) ) != (t.charAt(i)== t.charAt(j))){
                    return false;
                }
            }
        }
        return true;
    }
}






public class Main {

    public static void main(String[] arg) {
        boolean isomorphic = new leetcoder.Solution().isIsomorphic("add", "egg");
        System.out.println(isomorphic);;


    }

}