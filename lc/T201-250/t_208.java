package leetcoder;


//import java.util.*;
//Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true
//        说明:
//
class Trie {

    /** Initialize your data structure here. */
    public Trie() {
        head = new leetcoder.Trie.Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        leetcoder.Trie.Node t = head;
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i]-'a';
            if(t.next[n]==null)
                t.next[n]= new leetcoder.Trie.Node();
            t = t.next[n];
        }
        t.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        boolean flag = true;
        leetcoder.Trie.Node t = head;
        for (int i = 0; i < chars.length; i++) {
            int n =chars[i]-'a';
            if(t.next[n] ==null) return false;
            t = t.next[n];
        }
        return t.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        leetcoder.Trie.Node t = head;
        for (int i = 0; i < chars.length; i++) {
            int n =chars[i]-'a';
            if(t.next[n] ==null) return false;
            t = t.next[n];
        }
        return true;
    }
    private leetcoder.Trie.Node head;
    class Node{
        boolean flag = false;
        leetcoder.Trie.Node[] next = new leetcoder.Trie.Node[26];
    }
}
public class Main {

    public static void main(String[] arg) {
        leetcoder.Trie t  = new leetcoder.Trie();
        t.insert("asdf");
        System.out.println(t.search("asdf"));
        System.out.println(t.startsWith("asd"));

    }

}