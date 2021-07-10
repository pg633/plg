package  leetcoder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null||digits.length() == 0) return list;
        list.add("");
        for(int i=0;i<digits.length();i++)
            list = Listadd(list,digits.charAt(i));
        return list;
    }
    public List<String> Listadd(List<String> list,char c){
        List<String> ans = new LinkedList<>();
        switch(c){
            case '2':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'a');
                    ans.add(str+'b');
                    ans.add(str+'c');
                }
            }
            break;
            case '3':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'d');
                    ans.add(str+'e');
                    ans.add(str+'f');
                }
            }
            break;
            case '4':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'g');
                    ans.add(str+'h');
                    ans.add(str+'i');
                }
            }
            break;
            case '5':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'j');
                    ans.add(str+'k');
                    ans.add(str+'l');
                }
            }
            break;
            case '6':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'m');
                    ans.add(str+'n');
                    ans.add(str+'o');
                }
            }
            break;
            case '7':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'p');
                    ans.add(str+'q');
                    ans.add(str+'r');
                    ans.add(str+'s');
                }
            }
            break;
            case '8':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'t');
                    ans.add(str+'u');
                    ans.add(str+'v');
                }
            }
            break;
            case '9':
            {
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    ans.add(str+'w');
                    ans.add(str+'x');
                    ans.add(str+'y');
                    ans.add(str+'z');
                }
            }
            break;
        }

        return ans;
    }
}
