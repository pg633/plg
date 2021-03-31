
#include <vector>
#include <set>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int l,r;
    unordered_set<int> s;  
    Solution(int n_rows, int n_cols) {
        l = n_rows;
        r = n_cols;
    }
    
    vector<int> flip() {
        while(true){
            int x = rand()%l;
            int y = rand()%r;
            if(!s.count(x*l+r)){
                s.insert(x*l+r);
                return {x,y};
            }
        } 
    }
    
    void reset() {
        s.clear();
    }
}; 