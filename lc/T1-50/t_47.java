
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null ||nums.length==0) return list;

        Arrays.sort(nums);
        dfs(list,nums,new ArrayList<Integer>(),new boolean[nums.length]);
        return list;
    }

    void dfs( List<List<Integer>>  list , int []nums,List<Integer> tmp,boolean[]b){
        if(tmp.size() == nums.length){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(b[i]) {
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]&& !b[i-1])continue;
            b[i]=true;

            tmp.add(nums[i]);
            dfs(list,nums,tmp ,b);
            tmp.remove(tmp.size()-1);
            b[i]=false;
        }
    }
}