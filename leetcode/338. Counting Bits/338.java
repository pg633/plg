package leetcoder;


class Solution {
    public int[] countBits(int num) {
        int  []res = new int[num +1];
        for (int i = 0; i <=num; i++) {
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }
}
public class AAA {
    public static void main(String[] args) {

    }
}