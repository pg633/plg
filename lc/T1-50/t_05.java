package leetcoder;

import java.awt.SystemTray;
class Solution {
    public String longestPalindrome(String s) {
        String res ="";
        int len = s.length();
        for(int i=0;i<len;i++){
            res += "#"+s.charAt(i);
        }
        res+="#";
        len = res.length();
        int begin =0;
        int end = 0;
        for(int i=0;i<len;i++)
        {
            int l = i-1;int r=i+1;
            while(l>=0 && r<res.length() && res.charAt(l)== res.charAt(r)){
                l--;r++;
            }
            if(end-begin < r-l) {
                begin = l+1;
                end = r-1  ;
            }
        }
//        System.out.println(begin+"   "+ end);
//        System.out.println( res.substring(begin,end));

        String[] arr = res.substring(begin,end).split("#");
        res = "";
        for(String ss : arr){
            res+=ss;
        }
        return   res;
    }
}
