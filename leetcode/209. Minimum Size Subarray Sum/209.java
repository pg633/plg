package leetcoder;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0 ||s<0)return 0;
        int sum = 0;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            ((LinkedList<Integer>) q).add(nums[i]);
            sum+=nums[i];
            while(true){
                if(sum >= s){
                    if(res==0|| res> q.size()){
                        res = q.size();
                    }
                    sum -= q.poll();
                }else{
                    break;
                }
            }
        }
        return res;
    }
}



public class Main {

    public static void main(String[] arg) {

    }

}