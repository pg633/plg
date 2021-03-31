package leecoder;

import leetcoder.ListNode;

import java.util.*;


class Solution {
    private int max = 0;
    private int depp = 0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<Integer> [] g = new List [n] ;
        for (int i = 0; i < n; i++) g[i] = new ArrayList();
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        boolean [] vis = new boolean[n];
        int [] dis = new int[n];
        int [] pre = new int[n];
        dis[0] =0;
        vis[0] = true;
        dfs(0,dis,vis,pre,g);

        Arrays.fill(dis,0);
        Arrays.fill(pre,0);
        Arrays.fill(vis,false);
        int root = max;
        depp =0;
        dis[root] = 0;
        vis[root] = true;
        dfs(root,dis,vis,pre,g);

        root = max;
        for (int i = 0; i < depp/2; i++) {
            root =pre[root];
        }
        if((depp &1) ==0){
            res.add(root);
        }else{
            res.add(root);
            res.add(pre[root]);
        }
        return res;


    }

    private void dfs(int i, int[] dis, boolean[] vis, int[] pre, List<Integer>[] g) {
        if(dis[i] > depp){
            depp = dis[i];
            max = i;
        }
        for (Integer integer : g[i]) {
            if(vis[integer]) continue;
            vis[integer] = true;
            pre[integer] = i;
            dis[integer] = dis[i] + 1;
            dfs(integer,dis,vis,pre,g);
        }
    }
}



public class Main {
    public static void main(String[] args) {
        System.out.println("aaaaaaaaaaaaaa");
        List<Integer> minHeightTrees = new leecoder.Solution().
                findMinHeightTrees(
                        4,
                        new int[][]{{1,0},{1,2},{1,3}});

        minHeightTrees.forEach(System.out::println);

    }
}