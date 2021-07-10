#include <bits/stdc++.h>
using namespace std;



class Solution {
public:
    bool isIdealPermutation(vector<int>& A) {
        int len = A.size();
        int min = len;
        for(int i=len-1;i>=2;i--){
            min = min(min,A[i]);
            if(A[i-2] > min)  return false;
        }
        return true;
    }
};