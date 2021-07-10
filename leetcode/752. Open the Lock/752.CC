class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size() ==0 ) return 0;

        sort(points.begin(),points.end(),[](auto& l,auto& r) -> bool{
            return l[1]< r[1];
        });
        int end = points[0][1];
        int res = 1 ;
        for(int i=1;i<points.size();i++){
            if(end >= points[i][0] ) continue;
                res ++;
                end = points[i][1];
        }
        return res;
    }
};