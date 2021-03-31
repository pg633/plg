class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
       set<int> s;
       s.insert(getdis(p1,p4));
       s.insert(getdis(p2,p3));
       s.insert(getdis(p1,p3));
       s.insert(getdis(p2,p4));
       s.insert(getdis(p1,p2));
       s.insert(getdis(p3,p4));
       return s.size()==2 && s.count(0)!=0;
    }
    int getdis(vector<int>& p1, vector<int>& p2){
        return (p1[1] - p2[1])*(p1[1] - p2[1]) + (p1[0] - p2[0])*(p1[0] - p2[0]);
    }
    
};