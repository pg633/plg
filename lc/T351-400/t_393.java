package leetcoder;


import java.util.*;

class Solution {
    public boolean validUtf8(int[] data) {
        int []res = calc(data);
        int i = 0;
        while(i<res.length){
            int id = res[i];
            if(id ==0 ) i++;
            else if(id==2){
                if(i+1 >= res.length ||res[i+1]!=1) return false;
                i+=2;
            }else if(id ==3){
                if(i+2 >= res.length || res[i+1]!=1 || res[i+2]!=1   ) return false;
                i+=3;
            }else if(id==4){
                if(i+3 >= res.length ||res[i+1]!=1 || res[i+2]!=1 ||res[i+3]!=1   ) return false;
                i+=4;
            }else return false;
        }
        return true;
    }

    public int [] calc(int[] data) {
        int [] res= new int[data.length];


        for (int i = 0; i < data.length; i++) {
            char[] chars = Integer.toBinaryString(data[i]).toCharArray();
            if(chars.length !=8) {
                res[i] =0;
                continue;
            }
            int j = 0;
            for (; j < chars.length; j++) {
                if(chars[j] == '0')
                    break;
            }
            res[i] = j;
        }
        return res;
    }
}



public class AAA {
    public static void main(String[] args) {

        int[] calc = new Solution().calc(new int[]{255});
        for (int i : calc) {
            System.out.println(i);
        }


        boolean b = new Solution().validUtf8(new int[]{
                197, 130, 1
        });
        System.out.println(b);
    }
}
