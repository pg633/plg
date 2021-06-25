package leetcoder;

class Solution {
    public boolean isHappy(int n) {
        String s = String.valueOf(n);
        int i =0;
        while(s.length()!=1 ){
            s = calc(s);
            i++;
            if(i==Integer.MAX_VALUE) return false;
        }
        return  s.charAt(0) == '1' || s.charAt(0) == '7';
    }

    private String calc(String s) {
        char[] chars = s.toCharArray();
        long res =0 ;
        for(char c :chars){
            res += (c-'0')*(c-'0');
        }
        return String.valueOf(res);
    }
}


public class Main {

    public static void main(String[] arg) {
        System.out.println(new leetcoder.Solution().isHappy(10));


    }

}