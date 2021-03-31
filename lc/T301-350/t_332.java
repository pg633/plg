package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;
import sun.security.x509.AttributeNameEnumeration;

import java.util.*;


class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,List<String>> m = new TreeMap<>();
        for (String[] ticket : tickets) {
            if(m.containsKey(ticket[0])) m.get(ticket[0]).add(ticket[1]);
            else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(ticket[1]);
                m.put(ticket[0],strings);
            }
        }
        for (String s : m.keySet()) {
            Collections.sort(m.get(s));
        }
        List<String> res = new ArrayList<>();
        dfs(res,m,"JFK",tickets.length,new HashSet<>(),"");
        return res;



    }
    private boolean f = false;
    private void dfs(List<String> res, Map<String, List<String>> m, String curString, int length,
                     HashSet<String> set, String s) {
        res.add(curString);
        if(res.size() == length +1){
            f = true;
            return;
        }
        if(m.get(curString) == null){
            set.remove(s);
            res.remove(res.size()-1);
            return;
        }
        for (int i = 0; i < m.get(curString).size(); i++) {
            String s1 = m.get(curString).get(i);
            if(!set.contains(curString+"@"+i)){
                set.add(curString+"@"+i);
                dfs(res,m,s1,length,set,curString+"@"+i);
                if(f)return;
            }
        }
        set.remove(s);
        res.remove(res.size()-1);
    }
}






public class Main {
    public static void main(String[] args) {
        String [][] s = new String[][]
                {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        List<String> itinerary = new leecoder.Solution().findItinerary(s);
        for (String s1 : itinerary) {
            System.out.println(s1);

        }

    }
}