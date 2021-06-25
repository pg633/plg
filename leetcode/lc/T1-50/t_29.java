package leetcoder;

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor==-1) return 2147483647;
        boolean flag = false;
        if(dividend>0 ^ divisor>0)
            flag = true;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long d = 0 ;
        while(dvd>=dvs){
            long temp = dvs;
            long divide  = 1;
            while(dvd >= (temp<<1)){
                temp<<=1;
                divide<<=1;
            }
            dvd-=temp;
            d += divide;
        }

        return (flag)?(int)(0-d):(int)d;
    }
};