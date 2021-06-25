package leetcoder;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> list = new HashSet<>();
        char [] a = s.toCharArray();
        for(int i=1;i<=3;i++)
            for (int j=i+1;j<=i+3;j++)
                for(int k=j+1;k<=j+3;k++){
                    if (k >= s.length()) continue;
                    int ip1 = -1;
                    int ip2 = -1;
                    int ip3 = -1;
                    int ip4 = -1;

                    try{
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i , j);
                        String s3 = s.substring(j , k);
                        String s4 = s.substring(k);
                        ip1 = Integer.valueOf(s1);
                        ip2 = Integer.valueOf(s2);
                        ip3 = Integer.valueOf(s3);
                        ip4 = Integer.valueOf(s4);

                        if(!s1.equals(String.valueOf(ip1))
                                || !s2.equals(String.valueOf(ip2))
                                || !s3.equals(String.valueOf(ip3))
                                || !s4.equals(String.valueOf(ip4)) )
                            continue;


                    }catch (Exception e){
                        continue;
                    }
                    if (f(ip1) && f(ip2) && f(ip3) && f(ip4)) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(ip1);
                        sb.append(".");
                        sb.append(ip2);
                        sb.append(".");
                        sb.append(ip3);
                        sb.append(".");
                        sb.append(ip4);
                        list.add(sb.toString());
                    }
                }
        return new ArrayList<>(list);
    }
    public Boolean f(int t){
        if(t<0 ||t>255) return false;
        else return true;
    }

}


//        0.100.1.0,
//        1.0.0.10,
//        0.1.1.0,
//        0.1.0.10,
//        0.10.1.0,
//        0.10.0.10
//
//        "0.10.0.10",
//        "0.100.1.0"]



class Main{

    public static  void main(String []arg){


        Object p =(Object) new leetcoder.Solution().restoreIpAddresses("010010");

        System.out.println(p);

    }
}