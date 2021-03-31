package leetcoder;


import java.util.*;


class Solution {

    public List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)) return res;

        if(!wordList.contains(beginWord)) wordList.add(beginWord);

        HashMap<String, List<String>> from = new HashMap<>();
        List<String> vis = new ArrayList<>();
        HashMap<Integer,List<Integer>> nextWords  = new HashMap<>();

        for(int i=0;i<wordList.size();i++) nextWords.put(i,new ArrayList<>());
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                if(con(wordList.get(i),wordList.get(j))){
                    nextWords.get(i).add(j);
                    nextWords.get(j).add(i);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        vis.add(beginWord);
        while(!queue.isEmpty()){
            int levelCount = queue.size();
            List<String> tempVis = new ArrayList<>();
            while(levelCount-- >0){
                String temp = queue.poll();
                int n = wordList.indexOf(temp);
                List<Integer> nextWord = nextWords.get(n);
                for(Integer id : nextWord){
                    String s = wordList.get(id);
                    if(!vis.contains(s)){
                        if(!from.containsKey(s)){
                            tempVis.add(s);
                            queue.add(s);
                        }
                        if(from.containsKey(s)){
                            List<String> list = from.get(s);
                            list.add(temp);
                            from.put(s,list);
                        }else{
                            List<String> list= new ArrayList<>();
                            list.add(temp);
                            from.put(s,list);
                        }
                    }
                }

            }
            for(String s :tempVis){
                vis.add(s);
            }
            if(vis.contains(endWord)){
                break;
            }
        }

        from.put(beginWord,null);
        dfs(beginWord,endWord,new ArrayList<>(),from,res);
//        pt(from);
//        pi(nextWords);


        return res;
    }

    private void pi(HashMap<Integer, List<Integer>> from) {
        Set<Integer> strings = from.keySet();
        for(Integer ss:strings){

            System.out.print(ss+"\t:\t");
            List<Integer> orDefault = from.getOrDefault(ss, null);
            if(orDefault == null){
                System.out.println();
            }else{
                for(Integer s:orDefault){
                    System.out.print(s +" ");
                }
                System.out.println();
            }
        }

    }

    private void pt(HashMap<String, List<String>> from) {
        Set<String> strings = from.keySet();
        for(String ss:strings){

            System.out.print(ss+"\t:\t");
            List<String> orDefault = from.getOrDefault(ss, null);
            if(orDefault == null){
                System.out.println();
            }else{
                for(String s:orDefault){
                    System.out.print(s +" ");
                }
                System.out.println();
            }
        }


    }


    private void dfs(String beginWord, String endWord, List<String> templist, HashMap<String, List<String>> from, List<List<String>> res) {
        if(endWord.equals(beginWord)){
            templist.add(endWord);
            Collections.reverse(templist);
            res.add(templist);
            return;
        }
        templist.add(endWord);
        if(from.get(endWord)!=null){
            for(String s:from.get(endWord)){
                dfs(beginWord,s,new ArrayList<>(templist),from,res);
            }
        }
    }

    private boolean con(String a,String b){
        char[] arr1 = a.toCharArray();
        char[] arr2 =b.toCharArray();
        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                diff++;
            }
        }
        if(diff == 1) {
            return true;
        }
        return false;
    }
}






public class Main {

    public static void main(String[] arg) {
        int []num={9,1,4,7,3,-1,0,5,8,-1,6 };
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog","hit");
        System.out.println(new leetcoder.Solution().findLadders("hit",
                "cog", list));
        //"hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"
    }

}