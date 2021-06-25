#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int minSwap(vector<int> &A, vector<int> &B)
    {
        int n1 = 0, s1 = 1;
        for (int i = 1; i < A.size(); i++)
        {
            int n2 = INT_MAX;
            int s2 = INT_MAX;
            if (A[i] > A[i - 1] && B[i] > B[i - 1])
            {
                n2 = min(n1,n2);
                s2 = min(s1+1,s2);
            }
            if(A[i]>B[i-1] && B[i]>A[i-1] ){
                n2 = min(n2,s1);
                s2 = min(s2,n1+1);
            }
            n1 = n2 ;
            s1 = s2;
       
        }
        return min(n1,s1);
    }
};
