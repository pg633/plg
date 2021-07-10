class Solution {
public:
    bool checkValidString(string s) {
       // l 记录了（  pos 
        //  r 记录了 * pos   
        stack<int> l,r;
        for(int i=0; i<s.length();i++){
            if(s[i]=='(') l.push(i);
            else if(s[i]=='*') r.push(i);
            else{
                if(l.empty() && r.empty()) return false;
                if(!l.empty()) l.pop();
                else r.pop();
            }
        }
        while (!l.empty() && !r.empty())
        {
            if(l.top()> r.top()) return false;
            l.pop();r. pop();
        }
        return l.empty() ;
    }
};