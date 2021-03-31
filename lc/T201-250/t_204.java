package leetcoder;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countPrimes(int n) {
        boolean [] b = new boolean[n+1];
        List<Integer>list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if(!b[i]){
                b[i] = true;
                for (int j = 1; j*i < n ; j++) {
                    b[j*i] = true;
                }
                list.add(i);
            }
        }
        return list.size();

    }
}







public class Main {

    public static void main(String[] arg) {
        System.out.println(new leetcoder.Solution().countPrimes(2));

    }

}