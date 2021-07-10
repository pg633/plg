class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int l = 0;int r = arr.size()-k ;
        while(l<r){
            int m = l+ r >> 1 ;
            if(x- arr[m] > arr[m+k] - x) l = mid + 1 ;
            else r = mid ;
        }
        return vector<int>(arr.begin()+l,arr.begin()+l+k);
    }
};