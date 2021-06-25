package leetcoder;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list= new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] s1 = String.valueOf(o1).toCharArray();
                char[] s2 = String.valueOf(o2).toCharArray();
                for (int i = 0; i < s1.length && i<s2.length; i++) {
                    if(s1[i]!=s2[i])return s1[i]- s2[i];
                }
                if(s1.length < s2.length) return -1;
                else if(s1.length > s2.length) return 1;
                else return 0;
            }
        });
        return list;
    }
}

public class AAA {
    public static void main(String[] args) {


        List<Integer> list = new Solution().lexicalOrder(34);
        list.forEach(System.out::print);



    }
}
