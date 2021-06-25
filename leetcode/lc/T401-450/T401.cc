#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<string> readBinaryWatch(int num)
    {
        vector<string> res;
        dfs(0, 0, num, res, 0, 0);
        return res;
    }
    bool check(int l, int r)
    {
        return l <= 11 && r <= 59;
    }
    string make(int l, int r)
    {
        ostringstream ss;
        ss << l << ":";
        if (r < 10)
            ss << "0";
        ss << r;
        return ss.str();
    }
    void dfs(int now, int use, int len, vector<string> &res, int l, int r)
    {
        if (use == len)
        {
            if (check(l, r))
            {
                res.push_back(make(l, r));
            }
            return;
        }
        dfs(now + 1, use, len, res, l, r);
        int l1 = l;
        int r1 = r;
        if (use <= 4)
        {
            l1 += 1 << use;
        }
        else
        {
            r1 += 1 << (use - 4);
        }
        dfs(now + 1, use + 1, len, res, l1, r1);
    }
};





vector<string>res;
    unordered_map<int,int> hash={{0,1},{1,2},{2,4},{3,8},{4,1},{5,2},{6,4},{7,8},{8,16},{9,32}};
    void backtrack(int num,int start,pair<int,int>& time)
    {
        if(num==0)
        {
            if(time.first>11||time.second>59)//判断合法性
                return;
            string temp_hour=to_string(time.first);
            string temp_minute=to_string(time.second);
            if(temp_minute.size()==1)//如果minute只有一位要补0
                temp_minute.insert(0,"0");
            res.push_back(temp_hour+":"+temp_minute);//构造格式
            return;
        }
    
        for(int i=start;i<10;i++)
        {
            if(time.first>11||time.second>59)
                continue;
            pair<int,int>store=time;//保存状态
            if(i<4)
                time.first+=hash[i];
            else
                time.second+=hash[i];
            backtrack(num-1,i+1,time);//进入下一层，注意下一层的start是i+1，即从当前灯的下一盏开始
            time=store;//恢复状态
        }
    }
    vector<string> readBinaryWatch(int num) {
        pair<int,int>time(0,0);//初始化时间为0:00
        backtrack(num,0,time);
        return res;
    }
    