
class Solution {
    public String countAndSay(int n) {
        if(n==0) return null;
        String str ="1";
        for(int i=1;i<n;i++){
            str = func(str);
        }
        return str;
    }
    public String func(String s){
        int len = s.length();
        int start  = 1;
        int b = 0;
        String res ="";
        while(start<len){
            if(s.charAt(start) == s.charAt(b)){
                start++;
                continue;
            }else{
                res = res.concat(Integer.toString(start - b)+s.charAt(b));
                b= start;
                start++;

            }
        }
        res = res.concat(Integer.toString(start - b)+s.charAt(b));
        return res;
    }
}
