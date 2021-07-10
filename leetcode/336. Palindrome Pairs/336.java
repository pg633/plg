package leecoder;


import leetcoder.*;
import sun.security.x509.AttributeNameEnumeration;

import javax.swing.*;
import java.util.*;


  package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;
import sun.security.x509.AttributeNameEnumeration;

import javax.swing.*;
import java.util.*;


class Solution {
    private class TrieNode {
        leecoder.Solution.TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new leecoder.Solution.TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    private void addWord(leecoder.Solution.TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';

            if (root.next[j] == null) {
                root.next[j] = new leecoder.Solution.TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private boolean isPalindrome(String word, int i, int j) {
        while(i<j){
            if(word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public List<List<Integer>> palindromePairs(String[] words) {
        leecoder.Solution.TrieNode root = new leecoder.Solution.TrieNode() ;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            addWord(root,words[i],i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words,i,root,res);
        }
        return res;
    }

    private void search(String[] words, int i, leecoder.Solution.TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if(root.index >=0  && root.index != i && isPalindrome(words[i],j,words[i].length()-1))
                res.add(Arrays.asList(i,root.index));
            root = root.next[words[i].charAt(j)-'a'];
            if(root==null) return;
        }
        for (Integer integer : root.list) {
            if(integer == i) continue;;
            res.add(Arrays.asList(i,integer));

        }
    }
}

public class Main {
    public static void main(String[] args) {


    }
}