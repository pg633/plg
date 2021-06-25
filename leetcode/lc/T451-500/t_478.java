
class Solution {


    public int totalHammingDistance(int[] nums) {
        int res =0;
        for (int i = 0; i < 30; i++) {
            int one = 0;
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                one += nums[j]&1;
                nums[j]>>=1;
                temp += nums[j]==0?1:0;
            }
            res += one*(nums.length-one);
            if(temp == nums.length) break;
        }
        return res;
    }
}


class Solution {


    public int totalHammingDistance(int[] nums) {
        int res =0;
        for (int i = 0; i < 30; i++) {
            int one = 0;
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                one += nums[j]&1;
                nums[j]>>=1;
                temp += nums[j]==0?1:0;
            }
            res += one*(nums.length-one);
            if(temp == nums.length) break;
        }
        return res;
    }
}

