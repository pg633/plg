package leetcoder;


import java.util.HashMap;
import java.util.Stack;




class Solution {
    public String reverseWords(String s) {
        String res = "";
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; --i) {
            sb.append(words[i]).append(" ");
        }
        return sb.append(words[0]).toString();
    }
}


public class Main {

    public static void main(String[] arg) {


    }

}