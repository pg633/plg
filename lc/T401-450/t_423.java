package leetcoder;


import java.util.Arrays;

class Solution {
    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        String []  words =  new String []{"zero", "two", "four", "six", "eight", "one", "three",
                "five", "seven", "nine"};
        int [] nums = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int [] m = new int[26];
        char[] dif = {'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i'};
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            m[c-'a']++;
        }
        for (int i = 0; i < 10; i++) {
            int cnt = m[dif[i]-'a'];
            for (int j = 0; j < words[i].length(); j++) {
                m[words[i].charAt(j)-'a']-=cnt;
            }
            while (cnt-- !=0) {
                sb.append(nums[i]);
//                System.out.println(nums[i]);
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return  String.valueOf(chars);
    }

}



public class AAA {
    public static void main(String[] args) {
        String owoztneoer = new Solution().originalDigits("fviefuro");
        System.out.println(owoztneoer);

    }
}
