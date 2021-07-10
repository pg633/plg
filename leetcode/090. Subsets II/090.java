class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null )return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> tmp = new HashSet<>();
        dfs(tmp,new ArrayList<>() ,nums,0);
        return new ArrayList<>(tmp);
    }
    void dfs(Set<List<Integer>> s ,List<Integer> l ,int []num,int k){
        if(k>num.length) return;
        s.add(new ArrayList<>(l));
        for(int i =k;i<num.length;i++){
            dfs(s,l,num,i+1);
            l.add(num[i]);
            dfs(s,new ArrayList<>(l),num,i+1);

        }
    }
}
