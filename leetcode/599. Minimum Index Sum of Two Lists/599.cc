#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;


class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        unordered_map<string,int> m ;
        vector<string> v ; 
        int temp = list1.size() + list2.size()-2;
        for(size_t i = 0; i < list1.size(); i++)
        {
            m[list1[i]] = i;
        }
        
        for(size_t i = 0; i < list2.size(); i++)
        {
            if(m.count(list2[i])==1){
                int tmp  = m[list2[i]] + i;
                if(tmp == temp ){
                    v.push_back(list2[i]);
                }else if(tmp< temp){
                    temp = tmp;
                    v.clear();
                    v.push_back(list2[i]);

                }
            }
        }
        return v;
    }
};

int main(){

}