/*
б���Ż���DP (2D)
    ����״̬ת�Ʒ��̣�dp[i][j] = min{ dp[i-1][k] + f(j) - h(j)*g(k) + d(k) }
    �����k���Ǿ��ߣ����õľ��Ǿ��ߵĵ����ԡ�
    ��������Ҫö��i��j��Ȼ����O(1)��ʱ��ȷ��k��ȡֵ��������������£�i��j���ǳ�����k��δ֪����
����f(j)��h(j)������֪�ģ��������ǽ���Щֵ���й��ࡣ

1��������ֻ��i��j�йصı�����Ϊһ�࣬��Ϊֱ�ߵĽؾ�b��b = dp[i][j]-f(j)
2����j��k��˵Ĳ����������h(j)�������ֵ�����������Ϊб��K��g(k)��Ϊ�Ա���x��
3��ʣ�µĲ��־���Ӧ����y�ˣ�Ӧ����yһ���i��k�йأ���dp[i-1][k]+d(k)��
   �õ�ֱ�߷���y = kx+b
          dp[i-1][k]+d(k) = h(j)*g(k) + dp[i][j]-f(j)
   
Author: WhereIsHeroFrom
Update Time: 2018-3-30
Algorithm Complexity: O(nm) 
*/

#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

#define MAXN 1010
#define LL int
int n, m;
int a[MAXN], b[MAXN];
int sa[MAXN], sb[MAXN];
int dpIdx;
LL dp[MAXN][MAXN];

// �Ա���x���;���k��� 
LL X(int k) {
	return sa[k];
}

// Ӧ����y���;���k�Լ���һ��״̬��� 
LL Y(int k) {
	return sb[k] + dp[dpIdx-1][k];
}

// б��K��ֻȡ����j���ҵ������� 
LL K(int j) {
	return sa[j];
}

// y = Kx + b������b = dp[i][j] + B; 
// y = Kx + dp[i][j] + B
LL B(int j) {
	return sb[j-1] - sa[j-1]*sa[j];
}

// ���� dp[i][j] =  y - Kx - B

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
	int i, j; 
	// 1.����Ƿ�״̬
	memset(dp, -1, sizeof(dp));
	// 2.�����ʼ״̬
	dp[0][0] = 0;
	// 3.ö��i��j, ����dp[i][j]
	// ״̬ת�����£� dp[i][j] <- dp[i-1][k]
	// i��������㣬�������Ա�֤ K(j) ʼ�յ������� 
 	for(i =	1; i <= m; ++i) {
 		head = tail = 0;
 		dpIdx = i;
 		for(j = 1; j <= n; ++j) {
			// 4.���dp[i-1][j-1]���״̬�Ϸ�����ô���Լ��뵥������
			if(dp[i-1][j-1] != STATE_INVALID) {
				// 4.1 ά������͹������
				while(head + 1 < tail && isBigger(deq[tail-2], deq[tail-1], j-1))
					--tail;
				// 4.2 ���뵥������β��
				deq[tail++] = j-1;
			}
			// 5.ɾ�����С�����¼�á���
			while(head + 1 < tail && isSmaller(deq[head], deq[head+1], K(j)))
				++head;
	
			// 6. ����y = kx + b
			dp[i][j] = Y(deq[head]) - K(j)*X(deq[head]) - B(j);		 
		}
	}
	return dp[m][n];
}

int main() {
	int i;
	while(scanf("%d %d", &n, &m) != EOF) {
		if(!n && !m) {
			break;
		}
		for(i = 1; i <= n; ++i) {
			scanf("%d", &a[i]);
			sa[i] = sa[i-1] + a[i];
			b[i] = a[i] * sa[i];
			sb[i] = sb[i-1] + b[i];
		}
		++m;
		printf("%d\n", solve());
	}
	return 0;
}
