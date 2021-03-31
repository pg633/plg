#include <iostream>

using namespace std;

// RMQ ������Сֵѯ��
// ��ģ��������������Сֵ�����Ҫ�����ֵ�����Խ�������ȥ�෴����Ȼ������Сֵ����ȡ�����ɡ�
 
#define MAXN 50010
#define MAXM 17

// typedef __int64 ValueType;
// typedef double ValueType;
typedef int ValueType;

int lg2K[MAXN];

// n val[]    ��ʾԪ����Ĵ�С��Ԫ��ֵ   -in 
// ret[i][j]  ��ʾ��õ�RMQ����          -out  
void RMQ_Init(int n, ValueType val[], int (*ret)[MAXN]) {
	int i, j, k = 0;
	for(i = 1; i <= n; i++) {
		lg2K[i] = k - 1;
		if((1<<k) == i) k++;
	}
	for(i = 0; i < MAXM; i++) {
		for(j = 1; j <= n; j++) {
			if(i == 0) {
				ret[i][j] = j;
			}else {
				// ret[i][j] = getMinIdx( ret[i-1][j], ret[i-1][ j+(1<<i-1) ] );
				ret[i][j] = ret[i-1][j];
				int ridx = j + (1<<i-1);
				if ( ridx <= n ) {
					int r = ret[i-1][ridx];
					if( val[r] < val[ ret[i][j] ] ) {
						ret[i][j] = r;
					}
				}
			}
		}
	}
}

/*
    �����䳤��Ϊ2^k����X��ʾ������Ϊ[a, a + 2^k)��Y��ʾ������Ϊ(b - 2^k, b]��
����Ҫ����һ����������X���Ҷ˵������ڵ���Y����˵�-1���� a+2^k-1 >= b-2^k��
��2^(k+1) >= (b-a+1), ����ȡ��������2Ϊ�ף����� k+1 >= lg(b-a+1)����k >= lg(b-a+1) - 1��
kֻҪ��Ҫȡ��С��������������������( lg(x)������2Ϊ��x�Ķ��� )��
*/
int RMQ_Query(ValueType val[], int (*rmq)[MAXN], int a, int b) {
	if(a == b) {
		return a;
	}else if(a > b) {
		a = a^b, b = a^b, a = a^b;
	}
	int k = lg2K[ b-a+1 ];
	return val[ rmq[k][a] ] < val[ rmq[k][b-(1<<k)+1] ] ? rmq[k][a] : rmq[k][b-(1<<k)+1];
}

int Max[MAXM][MAXN], Min[MAXM][MAXN];
ValueType val[MAXN], unval[MAXN];
int n,  m;

int main() {
	int i;
	while( scanf("%d %d", &n, &m) != EOF ) {
		for(i = 1;i <= n; i++) {
			scanf("%d", &val[i]);
			unval[i] = -val[i];
		}
		RMQ_Init(n, val, Min);
		RMQ_Init(n, unval, Max);
		while( m-- ) {
			int x, y;
			scanf("%d %d", &x, &y);
			int minidx = RMQ_Query(val, Min, x, y);
			int maxidx = RMQ_Query(unval, Max, x, y);
			ValueType ret = -unval[maxidx] - val[minidx];
			printf("%d\n", ret);
		}
	}
	return 0;
}
