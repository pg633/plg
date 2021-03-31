import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res,num,target,"",0,0,0);
        return res;
    }

    private void dfs(List<String> res, String num, int target, String s, long now, long pre, int pos) {
        if(pos == num.length()){
            if(target == now)
                res.add(s);
            return;
        }
        for (int i = pos+1; i <= num.length(); i++) {
            long curNum = Long.valueOf(num.substring(pos,i));
            //if(String.valueOf(curNum).length() != i-pos-1) continue;
            if(num.charAt(pos) == '0' && i!=pos+1) continue;
            if(pos==0){
                dfs(res,num,target,num.substring(pos,i),curNum,curNum,i);
            }else {
                dfs(res,num,target,s+"+"+num.substring(pos,i),now + curNum,curNum,i);
                dfs(res,num,target,s+"-"+num.substring(pos,i),now - curNum,-curNum,i);
                dfs(res,num,target,s+"*"+num.substring(pos,i),now - pre+ pre*curNum,pre*curNum,i);

            }
        }
    }

}
