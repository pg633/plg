package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,s,0,new ArrayList<String>());
        return res;



    }

    private void dfs(List<List<String>> res, String s, int now, List<String> strings) {
        if(now==s.length()){
            res.add(new ArrayList<>(strings));
            return;
        }
        for (int i = now; i < s.length() ; i++) {
            if (isParti(s,now,i)){
                strings.add(s.substring(now,i+1));
                dfs(res,s,i+1,strings);
                strings.remove(strings.size()-1);
            }
        }
    }

    private boolean isParti(String s, int l, int r) {
        while (l<=r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else
            {
                return false;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] arg) {
        List<List<String>> aab = new leetcoder.Solution().partition("aab");
        for (List<String> s:aab){
            for (String s1 : s) {
                System.out.println(s1);
            }
        }

    }

}