package leetcoder;

class Solution {
    public void moveZeroes(int[] nums) {
        int Znum = -1;
        for (int i = 0; i < nums.length; i++) {
            if (Znum == -1) {
                if (nums[i] == 0) {
                    Znum = i;
                }
            } else {
                if (nums[i] != 0) nums[Znum++] = nums[i];
            }
        }
        if(Znum!=-1)
            for (int i = Znum; i < nums.length; i++) {
                nums[i] = 0;
            }
    }
}

public class Main {

    public static void main(String[] arg) {

    }

}

