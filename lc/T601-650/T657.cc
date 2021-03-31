class Solution {
public:
    bool judgeCircle(string moves) {
        map<int,int> m ;
        for(auto & c :moves){
            m[c]++;
        }
        return m['L'] == m['R'] && m['U'] == m['D'];
    }
};