package leetcoder;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null ||nums.length <k ) return new int[]{};
        Deque<Integer> q = new LinkedList<>();
        List<Integer> res =new ArrayList<>();

        for (int i = 0; i <nums.length; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            if(q.peekFirst() == i-k){
                q.pollFirst();
            }
            if(i>=k-1){
                res.add(nums[q.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}

public class Main {

    public static void main(String[] arg) {
        int[] ints = new leetcoder.Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));


    }

}

