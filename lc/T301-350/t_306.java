package leetcoder;


class Solution {
    public boolean isAdditiveNumber(String num) {

        for (int i = 1; i < num.length() ; i++) {
            for (int j = 1 ; j < num.length(); j++) {
                if(i+j < num.length()){
                    if (func(num,i,j+i)) return true;
                }
            }
        }
        return false;
    }

    private boolean func(String num, int i, int j) {
        long  n1 = Long.valueOf(num.substring(0,i));
        long n2 = Long.valueOf(num.substring(i,j));
        StringBuilder sb = new StringBuilder();
        sb.append(n1).append(n2);
        while(sb.length() < num.length()){
            long k = n1+n2;
            sb.append(k);
            n1 = n2 ;
            n2 = k;
        }
        return sb.toString().equals(num);
    }
}

public class Main {

    public static void main(String[] arg) {
        boolean additiveNumber = new leetcoder.Solution().isAdditiveNumber("112358");
        System.out.println(additiveNumber);

    }

}

