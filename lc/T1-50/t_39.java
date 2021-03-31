package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates == null ||candidates.length==0) return list;
        Arrays.sort(candidates);
        int len =candidates.length;
        dfs(list,new ArrayList<Integer>(),candidates,target,0);
        return list;
    }
    public void dfs(List<List<Integer>> list ,ArrayList<Integer> tmp ,int[]a ,int  t, int level){
        if(t ==0 ){
            list.add(new ArrayList<>(tmp));return ;

        }else if(t<0){
            return;
        }
        for(int i=level;i<a.length;i++){
            tmp.add(a[i]);
            dfs(list,tmp,a, t -  a[i],i);
            tmp.remove(tmp.size()-1);
        }
    }
}