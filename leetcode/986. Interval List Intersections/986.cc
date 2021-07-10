
#include <bits/stdc++.h>
using namespace std; //

// t886.cc
// class Solution
// {
// public:
//     vector<vector<int>> intervalIntersection(vector<vector<int>> &A, vector<vector<int>> &B)
//     {
//         int i = 0;
//         int j = 0;
//         vector<vector<int>> res;
//         while (i < A.size() && j < B.size())
//         {
//             int a1 = A[i][0], a2 = A[i][1];
//             int b1 = B[i][0], b2 = B[i][1];
//             if(b2>= a1 &&a1>=b1)
//              res.push_back({max(a1, b1), min(a2, b2)});
//             if(b2<a2) j++; else i++;
//         }
//         return res;
//     }
// };

// class Solution {
// public:
//     int maxEnvelopes(vector<vector<int>>& envelopes) {
//         if(envelopes.size()==0) return 0 ;
//             sort(envelopes.begin(), envelopes.end(),[](auto & l,auto & r){
//                 if(l[0] == r[0]) return l[1]>r[1];
//                 else return l[0]< r[0];
//             });
//             vector<int> dp (envelopes.size(),1);
//             for(int i = 0; i < envelopes.size();i++){
//                 for(int j = 0; j < i;j++){
//                     if(envelopes[i][1] > envelopes[j][1]){
//                         dp[i] = max(dp[i],dp[j] +1);
//                     }
//                 }
//             }
//             return *max_element(dp.begin(), dp.end());
//     }
// };
//914.cc
// class Solution {
// public:
//     int gcd(int a, int b) {
//         if (a % b == 0) {
//             return b;
//         }
//         else {
//             return gcd(b, a % b);
//         }
//     }

//     bool hasGroupsSizeX(vector<int>& deck) {
//         if(deck.size()<=1) return false;
//         map<int,int> m ;
//         for(auto it:deck) m[it]++;

//         auto it = m.begin();
//         int res = it->second;
//         while(++it!=m.end()){
//             res = gcd(res,it->second);
//         }
//         return res != 1 ;
//     }
// };
// 打印素数
// int countPrimes(int n)
// {
//     vector<bool> dp(n + 1, false);
//     int res = 0;
//     for (int i = 2; i <= n; i++)
//     {
//         if (!dp[i])
//         {
//             dp[i] = true;
//             for (int j = i * 2; j <= n; j += i)
//                 dp[j] = true;
//             res++;
//         }
//     }
//     return res;
// }

// class LRUCache
// {
// private:
//     int _size;
//     list<int> _list;
//     map<int, pair<int, list<int>::iterator>> _map;

// public:
//     LRUCache(int capacity)
//     {
//         _size = capacity;
//     }

//     int get(int key)
//     {
//         if (_map.find(key) == _map.end())
//             return -1;
//         _list.erase(_map[key].second);
//         _list.push_front(key);
//         _map[key].second = _list.begin();
//         return _map[key].first;
//     }

//     void put(int key, int value)
//     {
//         if (_map.find(key) != _map.end())
//         {
//             _list.erase(_map[key].second);
//             _list.push_front(key);

//         }
//         else
//         {
//             if(_list.size() == _size){
//                  _map.erase(_list.back());
//                 _list.pop_back();
//             }
//            _list.push_front(key);
//         }
//          _map[key] = make_pair(value,_list.begin());
//     }
// };

// class LRUCache {
// private:
//     int _size;
//     list<int> _list;
//     map<int,pair<int,list<int>::iterator> > _map;
// public:
//     LRUCache(int capacity) {
//         _size = capacity;
//     }
//     void update(map<int,pair<int,list<int>::iterator>>::iterator it){

//         _list.erase(it->second.second);
//         _list.push_front(it->first);
//         it->second.second = _list.begin();
//     }
//     int get(int key) {
//         auto it = _map.find(key);
//         if(it == _map.end()){
//             return -1;
//         }
//         update(it);
//         return it->second.first;
//     }

//     void put(int key, int value) {
//         auto it = _map.find(key);
//         if(it!=_map.end()){
//             update(it);
//         }else{
//             if(_list.size() == _size){
//                 _map.erase(_list.back());
//                 _list.pop_back();
//             }
//             _list.push_front(key);
//         }
//         _map[key] =make_pair(value,_list.begin());
//     }
// };

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

// class Solution
// {
// public:
//     double myPow(double x, int n)
//     {
//         if (n >= 0)
//             return poww(x, n);
//         else
//             return 1.0 / (x * (poww(x, -(n + 1))));
//     }
//     double poww(int x, int n)
//     {
//         if (n == 0)
//             return 1.0;
//         return (n&1? x : 1) * poww(x * x, n / 2);
//     }
// };

// int main()
// {
//     Solution s;
//     s.myPow(2, 10);
//     cout<<s.poww(2,2)<<endl;
//     // for(int i = 0; i <2;i++)cout<<s.poww(2,i)<<endl;
//     return 0;
// }

// class Solution {
// public:
//     int minDistance(string word1, string word2) {
//         vector<vector<int > > dp(word1.size()+1, vector<int>(word2.size()+1,0));
//         for (int i=0; i<=word1.size();i++) dp[i][0] =i;
//         for (int i=0; i<=word2.size();i++) dp[0][i]=i;

//         for(int i=1; i<=word1.size();i++)
//             for(int j=1; j<=word2.size(); j++)
//             {
//                 if(word1[i-1] == word2[j-1]){
//                     dp[i][j] =  dp[i-1][j-1];
//                 }else{
//                     dp[i][j] = min(dp[i-1][j-1],dp[i - 1][j],dp[i][j-1]) +1;
//                 }
//             }
//         return dp[word1.size()][word2.size()];
//     }
//     int min(int a,int b,int c){
//         return ::min(a,::min(b,c));
//     }
// };

// int main(){
//     Solution s;
//     cout<<s.minDistance("horse",
// "ros");
// }

// struct ListNode
// {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };

// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode(int x) : val(x), next(NULL) {}
//  * };
//  */
// // class Solution {
// // public:
// //     ListNode* reverseList(ListNode* head) {
// //         ListNode* pre = nullptr,*cur = head;
// //         while(cur !=nullptr) {
// //             ListNode* nxt = cur->next;
// //             cur->next = pre;
// //             pre = cur;
// //             cur = nxt;
// //         }
// //         return pre;
// //     }
// // };

// // 25

// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode(int x) : val(x), next(NULL) {}
//  * };
//  */

// class Solution
// {
// public:
//     ListNode *reverseKGroup(ListNode *head, int k)
//     {
//         if (head == nullptr)
//             return head;
//         ListNode *pre = nullptr, *cur = head;
//         for (int i = 0; i < k; i++)
//         {
//             cur = cur->next;
//             if (cur == nullptr)
//                 return head;
//         }
//         // 反转
//         for (int i = 0; i < k; i++)
//         {
//             ListNode *t = cur->next;
//             cur->next = pre;
//             pre = cur;
//             cur = t;
//         }
//         pre->next = reverseKGroup(cur, k);
//         return head;
//     }
// };

// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode(int x) : val(x), next(NULL) {}
//  * };
//  */
// class Solution
// {
// public:
//  ListNode *reverse(ListNode *head,ListNode *nxt){
//      ListNode *pre = nullptr,*cur = head;
//      while(cur!=nxt){
//          ListNode * t = cur->next;;
//          cur->next =pre;
//          pre = cur;
//          cur = t;
//      }
//      return pre;
//  }
//     ListNode *reverseKGroup(ListNode *head, int k)
//     {
//         ListNode *pre = head, *cur = head;
//         for(int i=0;i<k;i++){
//             if(cur == nullptr) return head;
//             cur = cur->next;
//         }
//         ListNode* new_head = reverse(pre,cur);
//         pre->next = reverseKGroup(cur,k);
//         return new_head;
//     }
// };

// class Solution
// {
// public:
//     vector<int> findDisappearedNumbers(vector<int> &nums)
//     {
//         sort(nums.begin(), nums.end());
//         nums.erase(
//             unique(nums.begin(), nums.end()));
//         int mx = *max_element(nums.begin(), nums.end());
//         vector<int> res;
//         for (int i = 1; i <= mx; i++)
//         {
//             if (!binary_search(nums.begin(), nums.end(), i))
//             {
//                 res.push_back(i);
//             }
//         }
//         return res;
//     }
// };

// class Solution
// {
// public:
//     vector<int> findErrorNums(vector<int> &nums)
//     {
//         vector<int> res;
//         for (int i = 0; i < nums.size(); i++)
//         {
//             int idx = abs(nums[i])-1;

//             if(nums[idx] < 0){
//                 res.push_back(idx+1);
//             }else{
//                 nums[idx] *=-1;
//             }
//         }
//         for(int i = 0;i<res.size();i++){
//             if(nums[i] >0){
//                 res.push_back(i+1);
//             }
//         }
//         return res;
//     }
// };
// vector<int> getRandom(list<int> list, int n)
// {
//     srand(time(0));
//     vector<int> v;
//     auto it = list.begin();
//     for (int i = 0; i < n; i++)
//         v.push_back(*it);
//     int i = n;

//     while (it != list.end())
//     {
//         int k = rand() % ++i;
//         if (k < n)
//             v[k] = *it;
//         ++it;
//     }

//     return v;
// }

// class uf
// {
// private:
//     int _count;
//     vector<int> fa;
//     vector<int> sz;

// public:
//     uf(int n)
//     {
//         _count = n;
//         fa.resize(n);
//         sz.resize(n);
//         int i = 0;
//         fill(fa.begin(), fa.end(), i++);
//         fill(sz.begin(), sz.end(), 1);
//     }
//     void un(int p, int q)
//     {
//         int fp = getf(p);
//         int fq = getf(q);
//         if (fp == fq)
//             return;
//         else
//         {
//             if (sz[fp] > sz[fq])
//             {
//                 fa[fq] = fp;
//                 sz[fp] += sz[fq];
//             }
//             else
//             {
//                 fa[fp] = fq;
//                 sz[fq] += sz[fp];
//             }
//             _count--;
//         }
//     }
//     int getf(int p)
//     {
//         while (fa[p] != p)
//         {
//             fa[p] = fa[fa[p]]; // 路径压缩
//             p = fa[p];
//         }
//         return p;
//     }
//     int count()
//     {
//         return _count;
//     }
//     bool connectes(int p, int q)
//     {
//         return getf(p) == getf(q);
//     }
// };

class Solution
{
public:
    bool findNumberIn2DArray(vector<vector<int>> &matrix, int target)
    {
        for (auto item : matrix)
            if (binary_search(item.begin(), item.end(), target))
                return true;
        return false;
    }
};

int main()
{
}