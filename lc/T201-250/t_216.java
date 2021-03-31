package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sum3Recursion(results,temp,k,n,1);
        return results;
    }

    public void sum3Recursion(List<List<Integer>> results, List<Integer> temp, int k, int n,int index) {
        if (n == 0 && temp.size()==k) {
            results.add(new ArrayList<>(temp));
            return;
        }
        if (n < 1 || temp.size() == k) return;
        for (int i = index; i <= 9 ; i++) {
            temp.add(i);
            sum3Recursion(results, temp, k, n-i,i+1);
            temp.remove(temp.size() - 1);
        }
    }
}


public class Main {

    public static void main(String[] arg) {
        List<List<Integer>> lists = new leetcoder.Solution().combinationSum3(3, 7);
        for (List<Integer> lis :lists){
            lists.forEach(System.out::print);
            System.out.println();
        }
    }

}