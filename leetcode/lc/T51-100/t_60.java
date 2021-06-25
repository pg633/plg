import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        String res ="";
        String num = "123456789";
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        for(int i=1;i<n;i++){
            list.add(i,i*list.get(i-1));
        }
        --k;
        for(int i=n;i>=1;i--){
            int j = k/list.get(i-1);
            k%=list.get(i-1);
            res+=num.charAt(j);
            num = del(num,j);
        }
        return res;
    }
    private String del(String s,int k){
        String tmp ="";
        for (int i=0;i<s.length();i++){
            if(i!=k)
                tmp+=s.charAt(i);
        }
        return tmp;
    }
}