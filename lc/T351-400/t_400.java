package leetcoder;

/**
 * 借鉴 ，太巧妙了 ，纯数学，
 */

class Solution {
    public int findNthDigit(int n) {
        if(n<=9) return n;
        long idx = 0;
        long sum = 0 ;
        while(true){
            long count = 9*(idx+1)*(long)Math.pow(10,idx);
            if(sum + count >=n){
                long cha = n -sum-1;
                long shang = cha/(idx+1);
                long yu = cha%(idx+1);
                long fi = (long) Math.pow(10,idx) + shang;
                return (fi+"").charAt((int)yu) - 48;
            }
            sum+=count;
            idx++;
        }
    }
}



public class AAA {
    public static void main(String[] args) {
        int nthDigit = new Solution().findNthDigit(2147483647);
        System.out.println(nthDigit);

    }
}
