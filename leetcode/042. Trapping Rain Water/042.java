package leetcoder;



class Solution {
    public int trap(int[] height) {
        if(height == null||height.length ==0 ) return  0;
        if(height.length == 1 ) return 0;
        // 求上升子序列
        int l = 0;
        int r = height.length-1;
        int lh = 0;
        int rh = 0;
        int ans =0;
        while(l<r){
            if(height[l]< height[r]){
                if(lh< height[l]) lh =height[l];
                else ans+= lh - height[l];
                l++;
            }else {
                if(rh < height[r]) rh = height[r];
                else ans+=rh - height[r];
                r--;
            }
        }
        return  ans;
    }
}


public class Main {
    public static void main(String[] arg) {
        leetcoder.Solution s = new leetcoder.Solution();
        int []a  = { 0,1,0,2,1,0,1,3,2,1,2,1};
        int it = s.trap(a);
        System.out.println(it);
    }
}
