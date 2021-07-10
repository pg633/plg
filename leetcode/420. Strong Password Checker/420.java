package leetcoder;


import java.util.*;

/**
 * 错误 版本
 */

class Solution {
    public int strongPasswordChecker(String s) {
        // 含有 6 - 20 字母
        // 至少一个小写 一个大写 一个数字
        // 不能连续出现三个相同的
        char[] chars = s.toCharArray();

        boolean isSmall = false,isBig =false,isNum = false;
        Map<Character,Integer> m = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
            if(c>='0' && c<='9')
                isNum = true;
            else if(c>='a' && c<='z')
                isSmall = true;
            else if(c>='A' && c<='Z')
                isBig = true;
        }
        int res = 0;
        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1) && s.charAt(i-2) == s.charAt(i-1)) {
                res++;
                i+=2;
            }
        }
        int res2 = 0;
        if(isSmall == false) res2++;
        if(isBig == false) res2++;
        if(isNum == false) res2++;

        res = Math.max(res,res2);
        int mSize = s.length();
        if(mSize < 6){
            return Math.max(res,6-mSize);
        }else if(mSize > 20){
            return Math.max(res,mSize-20);
        }else return res;


//        int mSize = m.keySet().size();
//        if(mSize < 6 ){
//            return 6- mSize > res ? 6-mSize :res;
//        }else if(mSize > 20){
//            PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1-o2;
//                }
//            });
//            List<Integer> tmp = new ArrayList<>(m.values());
//            for (Integer integer : tmp) {
//                q.add(integer);
//            }
//            int res3 = 0;
//            while(q.size() >20){
//                res3+=q.poll();
//            }
//            return Math.max(res,res3);
//        }else return res;

    }
}


public class AAA {
    public static void main(String[] args) {
        int aa123 = new Solution().strongPasswordChecker("aa123");
        System.out.println(aa123);
    }
}
