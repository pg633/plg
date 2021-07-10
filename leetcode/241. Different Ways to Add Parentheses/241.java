package leetcoder;

import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c= input.charAt(i);
            if(c=='+'|| c=='-' || c=='*'){
                List<Integer> list = diffWaysToCompute(input.substring(0, i));
                List<Integer> list1 = diffWaysToCompute(input.substring(i+1));
                for(Integer n1 :list){
                    for (Integer n2:list1) {
                        if(c=='+'){
                            res.add(n1+n2);
                        }else if(c=='-'){
                            res.add(n1-n2);
                        }else if(c=='*'){
                            res.add(n1*n2);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}



public class Main {

    public static void main(String[] arg) {



    }

}

