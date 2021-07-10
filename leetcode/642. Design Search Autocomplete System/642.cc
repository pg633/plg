class Solution {
public:
    string predictPartyVictory(string senate) {
        string next;
        int votes[2] = {0}; // 当前R和D可用的票数，0 -> R, 1 -> D
        while(true) {
            int cnts[2] = {0}; // next队列中R和D的数量，其中一个为0则结束
            for(auto c: senate) {
                int i = c == 'R'? 0: 1;
                if(votes[!i])
                    --votes[!i];
                else {
                    next.push_back(c);
                    ++votes[i];
                    ++cnts[i];
                }
            }
            if(cnts[0] == 0) return "Dire";
            else if(cnts[1] == 0) return "Radiant";
            senate = move(next);
        }
        return "Dire";
    }
};

作者：sinstar
链接：https://leetcode-cn.com/problems/dota2-senate/solution/c-xun-huan-tou-piao-dui-lie-by-sinstar/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。