package leetcoder;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,new ArrayList<Integer>(),n,k,0,0);
        return list;
    }
    void dfs(List<List<Integer>> list , List<Integer> lt ,int n,int k ,int now, int id){
        if(id == k){
            list.add(new ArrayList<>(lt));
            return;
        }
        if(now == n)return;

        dfs(list,lt,n,k,now+1,id);
        lt.add(now+1);
        dfs(list,lt,n,k,now+1,id+1);
        lt.remove(lt.get(lt.size()-1));

    }
}