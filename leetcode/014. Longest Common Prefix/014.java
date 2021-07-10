class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return null;
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String res = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            res = CompareString(res,strs[i]);
            if(res =="")return res;
        }
        return res;
    }
    public  String CompareString(String from , String to)
    {
        int len = Math.min(from.length(),to.length());
        for(int i=0;i<len;i++)
        {
            if(from.charAt(i) != to.charAt(i))
                return from.substring(0,i);
        }
        return from.substring(0,len);
    }
}