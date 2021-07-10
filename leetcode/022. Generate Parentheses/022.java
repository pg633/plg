package  leetcoder;

import java.util.LinkedList;
import java.util.List;

class Solution
{
    public List<String> generateParenthesis(int n)
    {
        List<String> res = new LinkedList<>();
        dfs(res,n,0,0,"");
        return res;
    }
    public void dfs(List<String> res  ,int n,int l,int r,String str)
    {
        if(l > n || r>n ) return ;
        if(l==r&& l==n) res.add(str);
        if(l==r) dfs(res,n,l+1,r,str+"(");
        else
        {
            dfs(res,n,l+1,r,str+"(");
            dfs(res,n,l,r+1,str+")");
        }
    }
}
