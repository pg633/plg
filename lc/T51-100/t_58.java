class Solution {
    public int lengthOfLastWord(String s){
        int ans =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')continue;
            while(i>=0 && s.charAt(i)!=' '){
                ans++;
                i--;
            }
            return ans;
        }
        return ans;
    }
}