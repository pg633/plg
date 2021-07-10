package leetcoder;


import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Integer,List<leetcoder.Solution.Point>> m = new HashMap<>();
        for (int i = 0; i < 26; i++) m.put(i ,new ArrayList<leetcoder.Solution.Point>());
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                m.get(board[i][j]-'a').add(new leetcoder.Solution.Point(i, j));
            }

//        for (int i = 0; i < 26; i++) {
//            System.out.print((char) (i+'a') + "       ");
//            List<Point> points = m.get(i);
//            points.forEach(System.out::print);
//            System.out.println();
//        }

        Set<String> res = new HashSet<>();
        for(String s : words){
            dfs(m,res,s,0,new ArrayList<>());
        }


        return new ArrayList<>(res);

    }

    private void dfs(Map<Integer, List<leetcoder.Solution.Point>> m, Set<String> res, String s, int now, ArrayList<leetcoder.Solution.Point> vis) {
        if(now == s.length()){
            res.add(new String(s));
            return;
        }
        List<leetcoder.Solution.Point> points = m.get(s.charAt(now)-'a');
        if(points == null) return;
        for(leetcoder.Solution.Point p : points){
            if(!can(vis,p))
                continue;
            vis.add(p);
            dfs(m,res,s,now+1,vis);
            vis.remove(vis.size()-1);
        }
    }

    private boolean can(ArrayList<leetcoder.Solution.Point> vis, leetcoder.Solution.Point p) {
        if(vis.isEmpty()) return true;
        if(vis.contains(p)) return false;
        int x = p.i;
        int y = p.j;
        leetcoder.Solution.Point point = vis.get(vis.size() - 1);
        return  (Math.abs(point.i - p.i ) ==1 &&point.j == p.j)  || (point.i == p.i && Math.abs(point.j - p.j ) ==1) ;
    }

    class Point{
        int i,j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}

public class Main {

    public static void main(String[] arg) {
        String[]  words =  new String[]{"a","a","oatht"};
        char [][] board = new char [][] {
//               {'o','a','a','n'},
//               {'e','t','a','e'},
//               {'i','h','k','r'},
//               {'i','f','l','v'}
                {'a'}
        };
        List<String> words1 = new leetcoder.Solution().findWords(board, words);
        words1.forEach(System.out::println);

    }

}