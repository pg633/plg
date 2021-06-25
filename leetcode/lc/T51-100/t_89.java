package leetcoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//
//class Solution {
//    public List<Integer> grayCode(int n) {
//
//        if(n==0) {
//
//            List<Integer> list2 = new ArrayList<>();
//            list2.add(0);
//            return list2;
//        }
//        List<Integer> t = grayCode(n-1);
//        List<Integer> list = new ArrayList<>(t);
//        Stack<Integer> s =new Stack<>();
//        for(Integer it : t){
//            int k = (int)(Math.pow(2,n-1))+it;
//            s.push(k);
//        }
//        while(!s.empty()){
//            int k = s.pop();
//            list.add(k);
//        }
//
//        return list;
//    }
//}

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list=  new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            list.add(i^(i>>1));
        }
        return list;
    }
}




class Main{
    public static  void main(String []arg){
        String s1 = "great", s2 = "rgeat";
        System.out.println( new leetcoder.Solution().grayCode(4) );;
    }
}