class Solution {
public:
    int findKthNumber(int m, int n, int k) {
        int l =1,r= n*m+1;
        while(l<r){
            int mid = l+ (r-l)/2;
            int cnt = 0;
            for(int i=1;i<=m;i++){
                cnt+= min(mid/m,n);
            }
            if(cnt > k){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
};