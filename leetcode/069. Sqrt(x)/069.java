package leetcoder;



class Solution1 {
    public int mySqrt(int x) {
        return (int)Math.floor(Math.sqrt(x));
    }
}



class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int l = 0;
        int r = 46340;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid*mid < x){
                l=mid+1;
            }else if(mid*mid > x){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return l-1;
    }
}
