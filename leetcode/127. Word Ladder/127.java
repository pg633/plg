package leetcoder;


import java.util.*;

class Solution {
    class lvs{
        String word;
        int level;

        public lvs(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if(end==-1) return 0;
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        boolean [][] dp = new boolean[wordList.size()][wordList.size()];
        HashMap<String,Boolean> vis = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(canMove(wordList.get(i),wordList.get(j)))
                    dp[i][j] = dp[j][i] = true;
            }
            vis.put(wordList.get(i),false);
        }
        Queue<leetcoder.Solution.lvs> q = new LinkedList<>();
        q.add(new leetcoder.Solution.lvs(beginWord,0));
        vis.put(beginWord,true);
        while(!q.isEmpty()){
            leetcoder.Solution.lvs tmp = q.poll();
            if(tmp.word.equals(endWord))
                return tmp.level+1;
            int n = wordList.indexOf(tmp.word);
            List<String> nxt = new LinkedList<>();
            for (int i = 0; i < wordList.size() ; i++) {
                if(dp[n][i]){
                    nxt.add(wordList.get(i));
                }
            }
            for(String s:nxt){
                if(!vis.get(s)){
                    q.add(new leetcoder.Solution.lvs(s,tmp.level+1));
                    vis.put(s,true);
                }
            }
        }

        return 0;
    }
    private boolean canMove(String s, String t) {
        int diff = 0;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if(chars[i]!=chars1[i]) diff++;

        return diff==1;
    }
}



public class Main {

    public static void main(String[] arg) {

        List<String> list = Arrays.asList("hot", "dot","dog","lot","log","cog");
        ArrayList<String> list1 = new ArrayList<>(list);
        int i = new leetcoder.Solution().ladderLength("hit", "cog",list1);
        System.out.println(i);

    }

}