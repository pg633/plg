package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int compress(char[] chars) {
        int now = 0;
        char c = '.';
        int res = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if(now==0){
                now++;
                c = chars[i];
                chars[j] = chars[i];
                j++;
            }else {
                if(c == chars[i]){
                    now++;
                }else{

                    c = chars[i];
                    if(now == 1){
                        res++;
                    }
                    else {
                        res+= 1+String.valueOf(now).length();
                        String s = String.valueOf(now);
                        for (int i1 = 0; i1 < s.length(); i1++) {
                            chars[j++] = s.charAt(i1);
                        }
                    }
                    chars[j++]=c;
                    now = 1;

                }
            }
        }

        if(now == 1) res++;
        else {
            res+= 1+String.valueOf(now).length();
            String s = String.valueOf(now);
            for (int i1 = 0; i1 < s.length(); i1++) {
                chars[j++] = s.charAt(i1);
            }
        }
        return res;
    }
}
public class AAA {
    public static void main(String[] args) {
        String a =  "abbbbbbbbbbbb";
        char[] chars = a.toCharArray();
        int compress = new Solution().compress(chars);
        System.out.println(compress);;
        System.out.println(Arrays.toString(chars));
    }
}