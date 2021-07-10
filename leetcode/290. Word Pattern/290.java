package leetcoder;

import sun.jvm.hotspot.tools.soql.SOQL;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> m = new HashMap<>();
        String[] split = str.split("\\s");
        if(pattern.length()!=split.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if(m.containsKey(pattern.charAt(i))){
                if(!m.get(pattern.charAt(i)).equals(split[i]))return false;
            }else{
                if(m.containsValue(split[i])) return false;
                else m.put(pattern.charAt(i),split[i]);
            }
        }
        return true;
    }
}


public class Main {

    public static void main(String[] arg) {
        String[] split = "dog cat cat dog".split("\\s");
        for (String s : split) {
            System.out.println(s);

        }


    }

}

