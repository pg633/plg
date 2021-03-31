package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length==0) return -1;
        for (int i = 0; i < gas.length; i++) {
            if(can(gas,cost,i)){
                return i;
            }
        }
        return -1;
    }

    private boolean can(int[] gas, int[] cost, int i) {
        int len = gas.length;
        int y = 0;
        for (int j = 0; j <len; j++) {
            int now = (i+j) %len;
            y+=gas[now];
            y-=cost[now];
            if(y<0) return false;
        }
        return true;
    }
}

public class Main {

    public static void main(String[] arg) {


    }

}