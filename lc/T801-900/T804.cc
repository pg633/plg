

#include <iostream>
#include <vector>
#include <set>
#include <queue>
using namespace std;


class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<std::string> w = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-"
            ,".--","-..-","-.--","--.."};
        set<string> s;
        for(const auto & it:words ){
            string ss = "";
            for(auto it2 :it){
                ss+=w[it2-'a'];
            }
            s.insert(ss);
        }
        return s.size();

    }
};


