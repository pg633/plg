package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates == null || candidates.length ==0 ) return list;
        Arrays.sort(candidates);
        dfs(list,new ArrayList<Integer>(),candidates,target,0,0);
        return list;
    }
    void dfs(List<List<Integer>> list ,List<Integer> tmp,int []a,int t,int sum,int now){
        if(t==sum){
            list.add(new ArrayList<>(tmp));
            return;
        }else if( now > a.length || ((now < a.length)&& t-sum < a[now])){
            return;
        }
        for(int i=now;i<a.length;i++){
            tmp.add(a[i]);
            dfs(list,tmp,a,t,sum+a[i],i+1);
            tmp.remove(tmp.size()-1);
            while(i+1<a.length && a[i+1]==a[i])i++;
        }
    }
}