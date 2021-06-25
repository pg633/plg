class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],i);
        }
        String [] strings = new String[nums.length];
        String[] Gold = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Arrays.sort(nums);
        for (int i = 0; i < 3 && i<nums.length ; i++) {
            strings[m.get(nums[nums.length-1-i])] = Gold[i];
        }

        for (int i = 3; i < nums.length; i++) {
            strings[m.get(nums[nums.length-1-i])] = (i+1)+"";
        }
        return strings;
    }
}
