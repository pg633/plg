#include <vector>
#include <iostream>
using namespace std;

class Solution {
private:
    vector<int> v;
    int sum = 0;
public:
    Solution(vector<int> w) {
       for(int i =0;i<w.size();i++){
           sum+=w[i];
           v[i] = sum;
       }
    }
    
    int pickIndex() {
        int k = rand()%sum;
        return bin_s(0,v.size()-1,k);     
    }
    int bin_s(int l,int r,int target){
        if(l>=r) return r;
        int mid = (l+r)/2;
        if(v[mid] == target ) return mid +1;
        else if(v[mid] >  target) bin_s(l,mid,target);
        else return bin_s(mid+1,r,target);
    }
};

 