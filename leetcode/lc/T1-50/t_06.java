package leetcoder;
class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0) return s;
        if(numRows==1) return s;
        int len = s.length();
        int row = (int)Math.ceil(s.length()/(2*numRows-2));
        String res="";
        int dw = numRows*2-2;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=row;j++){
                if(j*dw+i <len)
                    res+=s.charAt(j*dw+i);
                if(i==0)continue;
                if((j+1)*dw-i <len && (j+1)*dw-i != j*dw+i)
                    res+=s.charAt((j+1)*dw-i);
            }
        }

        return res;
    }
}
