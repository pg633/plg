

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.compareTo(s2) == 0 ) return true;

        char [] t1 = s1.toCharArray();
        char [] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);


        //    System.out.println( s1 + "    " + s2);

        if(!Arrays.equals(t1,t2) ) {
            return false;
        }
        for(int i =1;i<s1.length();i++){
            String tll = s1.substring(0,i);
            String tlr = s1.substring(i);

            String trl = s2.substring(0,i);
            String trr = s2.substring(i);

            if(isScramble(tll,trl) && isScramble(tlr,trr)) return true;

            String srr = s2.substring( t2.length - i );
            String srl = s2.substring(0,t2.length-i );

            if(isScramble(tll,srr) && isScramble(tlr,srl)) return true;
        }
        return  false;
    }
}






