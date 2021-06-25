class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean [][] b = new boolean[len1+1][len2+1];
        b[0][0] =true;
        for (int j=1;j<=len2;j++)
        {
            if(p.charAt(j-1)=='*')
            {
                b[0][j] = b[0][j-1];
            }
        }
        for(int i=0;i<len1;i++){
            for (int j=0;j<len2;j++){
                if(p.charAt(j)=='?'){
                    b[i+1][j+1] = b[i][j];
                }else if(p.charAt(j)=='*'){
                    b[i+1][j+1] = (  b[i+1][j+1]|| b[i+1][j]||b[i][j]||b[i][j+1]);
                }else {
                    if(s.charAt(i)==p.charAt(j))
                    {
                        b[i+1][j+1] = b[i][j];
                    }
                }
            }
        }

        return b[len1][len2];
    }
}
