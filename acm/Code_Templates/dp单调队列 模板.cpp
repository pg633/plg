#include <iostream>

using namespace std;

#define MAXN 200010
 
int a[MAXN], sum[MAXN];
int dp[MAXN], pre[MAXN];
int n, n2;
int k;
int ansValue, ansStart, ansEnd, ansLength;

void input() {
	scanf("%d %d", &n, &k);
	int i;
	for(i = 1; i <= n; ++i) {
		scanf("%d", &a[i]);
		a[i+n] = a[i];
	}
	n2 = n*2;
	sum[0] = 0;
	for(i = 1; i <= n2; ++i) {
		sum[i] = sum[i-1] + a[i];
	}
}

///////////////////////��������//////////////////////////
//////////////////////���K-�Ӵ�/////////////////////////
int deq[MAXN];
int head, tail;

void getMaxKSeq() {
	ansValue = -200000001;
	head = tail = 0;
	deq[tail++] = 0;
	
	
	for(int i = 1; i <= n2; ++i) {
		// ���Ƚ�����������ߺ͵�i��Ԫ�ؾ��볬��k��Ԫ���޳� 
		while(head < tail && i - deq[head] > k)
			++head;
			
		/////////////////////////////////////
		// �������ֵ 
		int idx = deq[head]; 
		if (sum[i] - sum[idx] > ansValue) {
			ansValue = sum[i] - sum[idx];
			ansStart = idx + 1;
			ansLength = i - idx;
		}else if(sum[i] - sum[idx] == ansValue && idx + 1 < ansStart) {
			ansStart = idx + 1;
			ansLength = i - idx;
		}else if(sum[i] - sum[idx] == ansValue && idx + 1 == ansStart && i - idx < ansLength) {
			ansLength = i - idx;
		}
		//////////////////////////////////////
		
		// ά�������������� 
		while(head < tail && sum[deq[tail-1]] > sum[i])
			--tail;
		// �����i����
		deq[tail++] = i;
	}
	ansEnd = ansStart + ansLength - 1;
	if(ansEnd > n) 
		ansEnd -= n;
}

int main() {
	int t;
	int i;
	scanf("%d", &t);
	while(t--) {
		input();
		getMaxKSeq(); 
		printf("%d %d %d\n", ansValue, ansStart, ansEnd);
	}
	return 0;
} 

/*
4 2
9 -3 10 -100

5 3
0 0 0 1000 -1000000
*/
