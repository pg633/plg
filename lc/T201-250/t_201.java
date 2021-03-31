package leetcoder;


class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int count = n-m+1;
        long c= 1,mask = 1;
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if(count<=c){
                if((m&mask) >=c && (n&mask)>=c && (n&mask)< c*2){
                    res|=c;
                }
            }
            c<<=1;
            mask = mask<<1|1;

        }
        return res;
    }
}





public class Main {

    public static void main(String[] arg) {
        System.out.println("aaaaaaaaaaaaa");
        System.out.println(new leetcoder.Solution().rangeBitwiseAnd(5, 7));


    }

}