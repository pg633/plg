package leetcoder;

import DateStruct.Alg.max;
import org.apache.commons.collections.map.HashedMap;
import sun.jvm.hotspot.tools.soql.SOQL;

import javax.print.attribute.standard.PrinterResolution;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> m = new  HashMap();
        int buils =0,cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                buils++;
            }else {
                m.put(secret.charAt(i),m.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i) && m.getOrDefault(guess.charAt(i),0)>0){
                cows++;
                m.put(guess.charAt(i),m.getOrDefault(guess.charAt(i),0)-1);
            }
        }
        return buils+"A"+cows+"B";
    }
}

public class Main {

    public static void main(String[] arg) {



    }

}

