package leetcoder;

class Solution {
    public int lengthOfLongestSubstring(String str) {
        if(str.length()==0) return 0;
        int len = str.length();
        int start =0;int end =0;
        int from =0;int to = 0;
        int i =0;
        Set<Character> s = new HashSet<Character>();
        while(i<len){
            if(s.contains(str.charAt(i))){
                while(str.charAt(start) != str.charAt(i)){
                    s.remove(str.charAt(start++));
                }
                start++;
                end = i;
            }
            else {
                s.add(str.charAt(i));
                end = i;
            }
            if((to-from ) < (end - start)){
                to = end;from = start;
            }
            i++;
        }
        return to-from+1;
    }
}