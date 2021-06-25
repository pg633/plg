class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0)return 0;
        int  len = needle.length();
        boolean flag = false;
        for(int i=0;i<=haystack.length()-len;i++){
            if(haystack.substring(i,len+i).compareTo(needle)==0)return i;
        }
        return -1;
    }
}
