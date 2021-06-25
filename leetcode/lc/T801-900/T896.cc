
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isMonotonic(vector<int>& A) {
         if(A.front()>A.back())reverse(A.begin(),A.end());
        return is_sorted_until(A.begin(),A.end())==A.end()?true:false;
    }
};