
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int []hash = new int[256];
        for (int i = 0; i < p.length();i++) hash[p.charAt(i)]++;

        int l=0;
        int r =0;
        int count = p.length();
        while (r<s.length()){
            if(--hash[s.charAt(r++)] >=0 ) count--;
            if(count == 0) res.add(l);
            if(r-l==p.length() && hash[s.charAt(l++)] ++ >=0)count++;
        }
        return res;
    }
}