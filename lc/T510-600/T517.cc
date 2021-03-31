#include<iostream>
#include<vector>
#include <algorithm>
#include <numeric>

using namespace std;


class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        int len = machines.size();
		int res = accumulate(machines.begin(),machines.end(),0);
		// cout <<res <<endl;
		if(res%len !=0) return -1;
		res /=len;
		for_each(machines.begin(),machines.end(),[&](int& i){i-=res;});
		res = 0 ;
		int tt=0;

		for(int i =0;i<len;i++){
			tt+=machines[i];
			res= max(res,max(machines[i],abs(tt)));
 		}
		return  res;
		
    }
};



int main(){ 
	Solution s;
	vector<int> v {1,0,5};
	cout<< s.findMinMoves(v);	
	 cout<<"asddddddd"<<endl;
	 return 0;
}