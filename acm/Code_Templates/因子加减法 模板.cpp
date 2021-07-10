/*
   ���� �Ӽ���
   �κ���Ȼ�������Ա�ʾ�������ĳ˻���
   �����ĳ˷��ͳ������ȽϺ�ʱ��������ת���������˻��ٽ������Ӻϲ������������ɡ�

Author: WhereIsHeroFrom
Update Time: 2018-3-19
Algorithm Complexity: O(sqrt(n))
*/

#include <iostream> 
#include <cstdio>
#include <cstring>
#include <vector>
#include <memory.h>

using namespace std;

#define MAXP 65540
#define LL long long

#define MAX_FACTOR 200
#define MAX_FACTORS 1010
// MAX_FACTOR ������� MAX_FACTORS��1/10

int primes[MAXP];
bool notprime[MAXP];

struct factor {
	int prime, count;
	factor() {
	} 
	factor(int p, int c) {
		prime = p;
		count = c;
	}
	void print() {
		printf("(%d, %d)\n", prime, count);
	}
};

struct factors {
	int factorCnt;
	factor data[MAX_FACTOR];

	factors(): factorCnt(0) {
	}

	// ��գ�һ�㷢���������ӷֽ�ǰ
	void clear() {
		factorCnt = 0;
	}

	// ����һ��������
	void push(factor f) {
		data[factorCnt++] = f;
	}

	bool samePrime(int selfIdx, const factors& other, int otherIdx) {
		return data[selfIdx].prime == other.data[otherIdx].prime;
	}

	// ������ϲ�
	factors operator+(const factors& other) {
		int i, j;
		factors ans;
		ans.clear();

		// �Լ��е�
		for(i = 0; i < factorCnt; ++i) {
			int p = data[i].prime;
			int cnt = data[i].count;
			for(j = 0; j < other.factorCnt; ++j) {
				if(samePrime(i, other, j)) {
					// �������Ҳ�У����ۼ�
					cnt += other.data[j].count;
					break;
				}
			}
			ans.push( factor(p, cnt) );
		}

		/// �Լ�û�У��������е� 
		for(i = 0; i < other.factorCnt; ++i) {
			for(j = 0; j < factorCnt; ++j) {
				if(samePrime(j, other, i)) {
					break;
				}
			}
			if(j == factorCnt) {
				ans.push( other.data[i] );
			}
		}
		return ans;
	}

	// ���������
	factors operator-(const factors& other) {
		factors ans;
		ans.clear();
		int i, j;
		for(i = 0; i < factorCnt; ++i) {
			int p = data[i].prime;
			int cnt = data[i].count;
			for(j = 0; j < other.factorCnt; ++j) {
				if(samePrime(i, other, j)) {
					cnt -= other.data[j].count;
					break;
				}
			}
			ans.push( factor(p, cnt) );
		}
		return ans;
	}

	void print() {
		for(int i = 0; i < factorCnt; ++i) {
			data[i].print();
		}
	}
};

// �����������ɸѡ�� 
void Eratosthenes() {
	memset(notprime, false, sizeof(notprime));
	notprime[1] = true;
	primes[0] = 0;
	for(int i = 2; i < MAXP; i++) {
		if( !notprime[i] ) {
			primes[ ++primes[0] ] = i;
		    //��Ҫע��i*i�������ͺ��ɸ��������⣬����ת���� __int64 
			for(LL j = (LL)i*i; j < MAXP; j += i) {
				notprime[j] = true;
			}
		}
	}
}

// ��ʽ�ֽ� - ��n�ֽ�������ݳ˻�����ʽ
// ������
// 252 = (2^2) * (3^2) * (7^1) 
// �� ans = [ (2,2), (3,2), (7,1) ]
void Factorization(int n, factors& ans) {
	ans.clear();
	if(n == 1) {
		return ;
	}
	// �����Գ� 
	for(int i = 1; i <= primes[0]; i++) {
		if(n % primes[i] == 0) {
			factor f(primes[i], 0);
			while( !(n % primes[i]) ) {
				n /= primes[i];
				f.count ++;
			}
			ans.push(f);
		}
		if(n == 1) {
			return ;
		}
	}
	// ©��֮������ ������MAXP�����������1�� 
	ans.push( factor(n, 1) );
}


factors Fac[MAX_FACTORS];

// ��ʼ��ǰMAX_FACTORS������������
void initFactors() {
	int i;
	for(i = 1; i < MAX_FACTORS; ++i) {
		Factorization(i, Fac[i]);
		/*if(i < 10) {
			printf("<%d>\n", i);
			Fac[i].print();
		}*/
	}
}
