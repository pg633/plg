package leetcoder;


import com.sun.jdi.IntegerType;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String intToRoman(int num) {
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            int count = num/nums[i];
            while(count!=0)
            {
                sb.append(romans[i]);
                count--;
            }
            num=num%nums[i];
        }
        return sb.toString();
    }
}
