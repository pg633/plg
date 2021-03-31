#include<iostream>
#include <vector>
#include <set>
#include <queue>
using namespace std;

class Solution {
public:
    int distributeCandies(vector<int>& candies) {
        set<int> s (candies.begin(),candies.end()) ;
        return min(s.size(),candies.size()/2) ;
    }
};





int main(){
   
   



}


