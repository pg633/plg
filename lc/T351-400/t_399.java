package leetcoder;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    private Map<String,String> fa = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String,Double> value = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0];
            String v = equations[i][1];
            if(!fa.containsKey(u) && !fa.containsKey(v) ){
                // u -> v
                fa.put(u,u);
                fa.put(v,u);
                value.put(v,1.0);
                value.put(u,values[i]);
            }else if(!fa.containsKey(u)){
                fa.put(u,v);
                value.put(u, values[i] * value.get(v));
            }else if(!fa.containsKey(v)){
                fa.put(v,u);
                value.put(v,value.get(u)/values[i]);
            }else {
                //都包括 需要merge
                union(u,v,value,values[i]);
            }
        }
        List<Double> res = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String u = queries[i][0];
            String v = queries[i][1];
            if(!value.containsKey(u) || !value.containsKey(v)
                    ||getf(u)!=getf(v)){
                res.add(-1.0);
            }
            else res.add(value.get(u)/value.get(v));
        }
        return res.stream().mapToDouble(Double::valueOf).toArray();

    }

    private String getf(String u) {
        if(fa.get(u) == u) return u;
        fa.put(u,getf(fa.get(u)));
        return fa.get(u);
    }

    private void union(String u, String v, Map<String, Double> value, double value1) {
        String fu = fa.get(u);
        String fv = fa.get(v);

        double ra = value.get(v)*value1/value.get(u);
        for (String s : value.keySet()) {
            if(getf(s) ==fu){
                value.put(s,value.get(s)*ra);
            }
        }
        fa.put(fv,fu);
    }
}



public class AAA {
    public static void main(String[] args) {


    }
}
