package leetcoder;

import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int a=1,b=1,c=1;
        int aa =0,bb=0,cc=0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int num = 0;
        while(num<n){
            list.add(min(a,b,c));
            ++num;
            while(list.get(aa)*2 <=list.get(list.size()-1)){
                aa++;
            }
            a=list.get(aa)*2;
            while(list.get(bb)*3 <=list.get(list.size()-1)){
                bb++;
            }
            b=list.get(bb)*3;
            while(list.get(cc)*5 <=list.get(list.size()-1)){
                cc++;
            }
            c=list.get(cc)*5;
        }
        return list.get(list.size()-1);
    }

    private Integer min(int a, int b, int c) {
        return Math.min(c,Math.min(a,b));
    }
}


public class Main {

    public static void main(String[] arg) {
        int i = new leetcoder.Solution().nthUglyNumber(10);
        System.out.println(i);

    }

}

