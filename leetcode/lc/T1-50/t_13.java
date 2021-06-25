package leetcoder;


import java.util.HashMap;
import java.util.Map;



class Solution {
    public int romanToInt(String s) {
        if(s.isEmpty()) return 0;
        Map<Character,Integer> hm  = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);

        hm.put('D', 500);
        hm.put('M', 1000);
        int res = 0;
        int value =0;
        int temp  =0;
        for(int i=s.length()-1;i>=0;i--)
        {
            value = hm.get(s.charAt(i));
            if(temp<=value){
                res+=value;
                temp=value;
            }
            else
            {
                res -= value;
                temp = value;
            }
        }
        return res;

    }
}
