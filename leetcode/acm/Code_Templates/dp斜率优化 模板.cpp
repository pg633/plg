/*
  ���⣺����N(N <= 400000)����a[N]��������Ҫ�����ǹ��࣬ÿ������T(1 < T <= N)����������
  ͬһ��Ļ���Ϊÿ�����ּ�ȥ��С�Ǹ�����֮�͡�ϣ���������������ܻ�����С���������С���ѡ�

  ��⣺dp[i] = {dp[j] + sum[i]-sum[j] - (i-j)a[j+1] | 0<=j<i}
		
		b = dp[i] - sum[i]
		y = dp[j] - sum[j] + j*a[j+1]
		k = i
		x = a[j+1]

		y = kx + b

		��������ά�� ����͹�� ���ߣ����������ڴ洢�ĵ�Ϊ��ת�Ƶ�״̬i��״̬j��
*/

#include <iostream>
#include <algorithm>

using namespace std;

#define MAXN 400010
#define LL long long
int N, T;
int a[MAXN];
LL sum[MAXN], dp[MAXN];

LL X(int idx) {
	return a[idx+1];
}

LL Y(int idx) {
	return (dp[idx] - sum[idx] + (LL)idx * (LL)a[idx+1]);
}

LL K(int i) {
	return i;
}

// б���ж���K(A, B) >= K(B, C)
bool isBigger(int A, int B, int C) {
	// K(A, B) = (Y(B)-Y(A)) / (X(B)-X(A))
	// K(C, B) = (Y(C)-Y(B)) / (X(C)-X(B))
	LL XB = X(B);
	LL YB = Y(B);
	return (YB-Y(A))*(X(C)-XB) >= (Y(C)-YB)*(XB-X(A));
}

// б���ж���K(A, B) <= slope
bool isSmaller(int A, int B, LL slope) {
	// K(A, B) = (Y(B)-Y(A)) / (X(B)-X(A))
	return (Y(B)-Y(A)) <= slope*(X(B)-X(A));
}

int deq[MAXN];
int head, tail;
#define STATE_INVALID -1

LL solve() {
	// 1.���������ÿ�
	head = tail = 0;
	// 2.�����ʼ״̬
	dp[0] = 0;
	// 3.����Ƿ�״̬(���ĸ�������T�����޷���Ϊһ�࣬�������Žⲻ����)
	for(int i = 1; i < T; ++i) {
		dp[i] = STATE_INVALID;
	}
	// 4.ö��i������dp[i] (T<=i<=N)
 	for(int i =	T; i <= N; ++i) {
		// 5.���dp[i-T]���״̬�Ϸ�����ô���Լ��뵥������
		if(dp[i-T] != STATE_INVALID) {
			// 5.1 ά������͹������
			while(head + 1 < tail && isBigger(deq[tail-2], deq[tail-1], i-T))
				--tail;
			// 5.2 ���뵥������β��
			deq[tail++] = i-T;	
		}

		// 6.ɾ�����С�����¼�á���
		while(head + 1 < tail && isSmaller(deq[head], deq[head+1], i))
			++head;

		// 7. ����dp[i] = y - kx + sum[i]
		dp[i] = Y(deq[head]) - K(i)*X(deq[head]) + sum[i];
	}
	return dp[N];
}

int main() {
	int i;
	while(scanf("%d %d", &N, &T) != EOF) {
		for(i = 1; i <= N; i++) {
			scanf("%d", &a[i]);
		}
		sort(a + 1, a + N + 1);
		for(i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + a[i];
		}
		printf("%lld\n", solve());
	}
	return 0;
}