package leetcoder;


import Concurrency.mid.Collections2;

import java.lang.reflect.Array;
import java.util.*;



class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new leetcoder.WordDictionary.Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        leetcoder.WordDictionary.Node t = head;
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i]-'a';
            if(t.next[n]==null)
                t.next[n]= new leetcoder.WordDictionary.Node();
            t = t.next[n];
        }
        t.flag = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();

        return dfs(chars,0,head);
    }

    private boolean dfs(char[] chars, int i, leetcoder.WordDictionary.Node head) {
        if( head== null) return false;
        if(chars.length == i) {

            return head.flag;
        }

        if(chars[i] == '.'){
            for (int j = 0; j < 26; j++) {
                int n = 'a' + j;
                if(dfs(chars,i+1,head.next[j])) return true;
            }
        }else {
            int n = chars[i] - 'a';
            if(head.next[n] == null) return false;
            return dfs(chars,i+1,head.next[n]);
        }
        return false;
    }

    private leetcoder.WordDictionary.Node head;
    class Node{
        boolean flag = false;
        leetcoder.WordDictionary.Node[] next = new leetcoder.WordDictionary.Node[26];
    }

}




public class Main {

    public static void main(String[] arg) {
        leetcoder.WordDictionary wordDictionary = new leetcoder.WordDictionary();
        wordDictionary.addWord("asd");
        boolean search = wordDictionary.search("..d");
        System.out.println(search);;

    }

}