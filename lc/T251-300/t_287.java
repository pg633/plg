package leetcoder;



class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int t = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow ) break;
        }
        while(true){
            slow = nums[slow];
            t = nums[t];
            if(slow == t) break;
        }
        return slow;
    }

};






public class Main {

    public static void main(String[] arg) {

    }

}

