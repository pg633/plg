
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //List<List<Integer>> list =new ArrayList<>();

        if(nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        dfs(list,new ArrayList<Integer>(),nums ,0);


        return new ArrayList<>( list);
    }
    void dfs(Set<List<Integer>> list, List<Integer> lt, int [] nums , int k  ){
        list.add(new ArrayList<>(lt));
        for(int i=k;i<nums.length;i++){
            lt.add(nums[i]);
            dfs(list,lt,nums,i+1);
            lt.remove(lt.remove(lt.size()-1));
        }
    }
}

