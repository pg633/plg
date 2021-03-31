package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;


class Solution {
    private List<String> [] arr;
    private List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        arr = new ArrayList [s.length()] ;
        res = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            arr[i] = new ArrayList<>();
//        }
        arr[0]= new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if(arr[i]==null)continue;
            for(String word :wordDict){
                if(i+word.length() <=s.length() && word.equals(s.substring(i,i+word.length()))){
                    arr[i].add(word);
                    if(i+word.length() == s.length()){
                        flag = true;
                    }
                    if(i+word.length() < s.length() && arr[i+word.length()]==null){
                        arr[i+word.length()] = new ArrayList<>();
                    }
                }
            }

        }
        if(!flag){
            return res;
        }
        dfs(s,0,new ArrayList<String>(),wordDict);
        return res;
    }
    private void dfs(String s, int from, List<String> words, List<String> wordDict) {
        if (from == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String ss :words){
                sb.append(" ").append(ss);
            }
//            System.out.println(sb.toString());
            res.add(sb.toString().substring(1));
            return;
        }else{
            for(String word: arr[from]) {
                words.add(word);
                dfs(s, from + word.length(), words, wordDict);
                words.remove(words.size()-1);
            }
        }
    }
}


public class Main {

    public static void main(String[] arg) {

        List<String> b = new leetcoder.Solution().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        b.forEach(System.out::println);

    }

}