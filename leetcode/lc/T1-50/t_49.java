import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list =new ArrayList<>();
        if(strs==null||strs.length==0)return list;
        Map<String,Integer> m = new HashMap<>();
        int k=0;
        for(String s:strs){
            char [] a = s.toCharArray();
            Arrays.sort(a);
            String q = new String (a);
            int tmp=0;
            if(m.containsKey(q)){
                tmp = m.get(q);
            }else{
                tmp = k;
                m.put(q,k++);
            }
            if(list.size()>tmp){
                list.get(tmp).add(s);
            }else{
                List<String> tt = new  ArrayList<String>();
                tt.add(s);
                list.add(tt );
            }
        }
        return list;

    }
}