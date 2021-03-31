package leetcoder;


import java.util.*;

/**
 * TLE 搜索超时
 */

class Solution1 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(n==0 || n==1) return true;
        return dfs(stones,0,0);
    }

    private boolean dfs(int[] stones, int pos, int w) {
        if(pos == stones.length-1) return true;
        if(pos >  stones.length-1 )return false;
        for (int i = -1; i <=1 ; i++) {
            int next = stones[pos] + i + w;
            if(w+i < 0) continue;;
            for (int j = pos+1; j < stones.length ; j++) {
                if(stones[j] == next) {
                    if(dfs(stones,j,w+i))
                        return true;
                }else if(stones[j] > next) break;
            }
        }
        return false;
    }
}

class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length ==0) return false;
        Map<Integer,Set<Integer>> m = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            m.put(stones[i],new HashSet<>());
        }
        m.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (Integer now : m.get(stones[i])) {
                for (int j = now-1; j <= now+1; j++) {
                    if(j>0 && m.containsKey(stones[i] + j)){
                        m.get(stones[i] + j).add(j);
                    }
                }
            }
        }
        return !m.get(stones[stones.length-1]).isEmpty();
    }
}

public class AAA {
    public static void main(String[] args) {
        boolean b = new Solution().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        System.out.println(b);
    }
}
