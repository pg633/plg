class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> st= new HashSet<>();
        Set<String> list= new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
            String substring = s.substring(i, i + 10);
            if(st.contains(substring)){
                list.add(substring);
            }else{
                st.add(substring);
            }
        }
        return new ArrayList<>(list);
    }
}