package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Set<Integer> set = new TreeSet<>();
        for(int id:nums){
            set.add(id);
        }
        List<Integer> list=  new ArrayList<>(set);
//        System.out.println(list.size());
//       list.forEach(System.out::println);
        int x = 1;
        int id =x;
        for(int i=1;i<list.size();i++){
            if(list.get(i) == list.get(i-1)+1){
                x++;
            }else {
                x = 1;
            }
            id = Math.max(id,x);
        }
        return id;
    }
}




public class Main {

    public static void main(String[] arg) {
        int []num={9,1,4,7,3,-1,0,5,8,-1,6 };
//        System.out.println(new leetcoder.Solution().longestConsecutive(num));
    }

}