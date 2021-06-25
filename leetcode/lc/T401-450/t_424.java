
class Solution {
    public int characterReplacement(String s, int k) {
        int max =0, start= 0,end =0,cur =0;
        int [] count = new int[26];
        while (end<s.length()){
            cur = Math.max(cur,++count[s.charAt(end) - 'A']);
            while(end - start +1 -cur > k){
                --count[s.charAt(start++) - 'A'];
            }
            max = Math.max(end -start+1,max);
            ++end;
        }
        return max;
    }
}

