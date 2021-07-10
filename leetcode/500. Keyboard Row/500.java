package leetcoder;


import java.util.*;
class Solution {
    public String[] findWords(String[] words) {
        String[] rows = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String before = word;
            word = word.toLowerCase();
            int k = 0;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if(!flag) break;
                if(i==0){
                    if(rows[0].indexOf(word.charAt(i)) !=-1 ){
                        k = 0;
                    }else if (rows[1].indexOf(word.charAt(i))!=-1) {
                        k = 1;
                    }else if (rows[2].indexOf(word.charAt(i))!=-1) {
                        k = 2;
                    }
                }else{
                    if(rows[k].indexOf(word.charAt(i)) ==-1){
                        flag = false;
                    }
                }
            }
            if(flag){
                res.add(before);
            }
        }
        String[] rr = new String[res.size()];
        return res.toArray(rr);
    }
}


public class AAA {
    public static void main(String[] args) {
        String[] res = new String[]{ "Hello", "Alaska", "Dad", "Peace"};

        String[] words = new Solution().findWords(res);
        for (String word : words) {
            System.out.println(word);
        }


    }
}