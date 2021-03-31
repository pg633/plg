package leecoder;

import leetcoder.ListNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int maxProduct(String[] words) {
        int [] vis = new int[words.length];
        for (int j = 0; j <words.length ; j++) {
            String word = words[j];
            int k = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                k |= (1<<(c-'a'));
            }
            vis[j] = k;
        }
        int a = -1;
        int b = -1;
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((vis[i] & vis[j]) == 0){
                    if(max < words[i].length() * words[j].length()){
                        max = words[i].length() * words[j].length();
                    }
                }
            }
        }
        return max;

    }
}



public class Main {
    public static void main(String[] args) {

        int i = new leecoder.Solution().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
        System.out.println(i);
    }
}