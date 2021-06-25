#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    struct nd{ 
        string s;
        int n;
    
    };
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string,int>  m ;
        for_each(words.begin(), words.end(), [&](string it) {
            m[it]++;
        }); 
        
        vector<nd >v ;

        for(auto const & t : m ){ 
             v.push_back({t.first,t.second});
        }
        
        sort( v.begin(), v.end(),[](nd l ,nd r ){ return l.n > r.n;});
        for_each(v.begin(),v.end(),[](nd it){
            cout<<it.s << " " <<it.n <<endl;
        })
        vector<string> res ;
        for(auto i = 0; i< k ;i++){
            res.push_back(v[i].s);
        }
        return res;
    }
};



int main(){ 
    vector< string> v {"i", "love", "leetcode", "i", "love", "coding"};
    Solution s ;
    auto it = s.topKFrequent(v,2);
    for(auto i : it){
        cout<<i<<endl;
    }



    return 0;
}