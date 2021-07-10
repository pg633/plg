package leetcoder;

import DateStruct.Alg.max;
import org.apache.commons.collections.map.HashedMap;
import sun.jvm.hotspot.tools.soql.SOQL;

import javax.print.attribute.standard.PrinterResolution;
import java.lang.reflect.Array;
import java.util.*;


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        rm1(res,s,0,0);
        return res;
    }

    private void rm1(List<String> res, String s, int from, int to) {

        int count = 0;
        for (int i = from; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i)==')')count--;
            if(count  >=0)continue;

            for (int j = to; j<= i; j++) {
                if (s.charAt(j)!=')')continue;;
                if(j==to || s.charAt(j-1)!=')')
                    rm1(res,s.substring(0,j)+s.substring(j+1),i,j);
            }
            return;
        }
        rm2(res,s,s.length()-1,s.length()-1);

    }

    private void rm2(List<String> res, String s, int from, int to) {
        int count = 0;
        for (int i = from;i<s.length() &&  i >= 0 ; i--) {
            if(s.charAt(i) == ')') count++;
            else if(s.charAt(i)=='(')count--;
            if(count  >=0)continue;

            for (int j = to; j<s.length() && j >= i; j--) {
                if (s.charAt(j)!='(')continue;;
                if(j==to || s.charAt(j+1)!='(')
                    rm2(res,s.substring(0,j)+s.substring(j+1),i-1,j-1);
            }
            return;
        }
        res.add(s);
    }
}



public class Main {

    public static void main(String[] arg) {
        List<String> strings = new leetcoder.Solution().removeInvalidParentheses(")(");
        for (String string : strings) {
            System.out.println(string);

        }


    }

}

