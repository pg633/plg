package alg;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

  class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int [2];
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            m.put(nums[i],i);
        }
        for(int i=0;i< nums.length;i++){
            int v = target - nums[i];
            if(m.containsKey(v) && m.get(v) != i){
                res[0] = i;
                res[1] = m.get(v);
                return res;
            }
        }
        return res;
    }
}
public class t_01 {
    public static void main(String []arg){
        Map<Integer,Integer> m  = new HashMap<>();
        m.put(10,1);
        m.put(10,2);
        for(Map.Entry<Integer,Integer> it : m.entrySet()){
            System.out.println(it.getKey()+ "   "+ it.getValue());
        }

    }
}
