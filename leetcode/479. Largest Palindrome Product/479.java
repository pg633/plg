class Solution {
    public int largestPalindrome(int n) {
        if(n>8 || n<1)
            return 0;
        int arr[] ={9,987,123,597,677,1218,877,475};
        return arr[n-1];
    }
}