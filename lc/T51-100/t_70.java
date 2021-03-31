class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        n-=2;
        int n1 = 1,n2 = 2 ,n3 =n1+n2;
        while(n-- !=0){
            n1 = n2 ;
            n2 = n3;
            n3 = n1+n2;
        }
        return n2;
    }
}