package leetcoder;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null ||nums.length==0) return list;
        dfs(list,nums,new ArrayList<Integer>(),new boolean[nums.length]);
        return list;
    }
    private boolean f(boolean[] b){
        for(int i=0;i<b.length;i++) {
            if (b[i] == false)
                return false;
        }
        return true ;
    }
    void dfs( List<List<Integer>>  list , int []nums,List<Integer> tmp,boolean[]b){
        if(f(b)){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(b[i] == true) continue;
            b[i] = true;
            tmp.add(nums[i]);
            dfs(list,nums,tmp,b);
            tmp.remove(tmp.size()-1);
            b[i]= false;
        }
    }
}