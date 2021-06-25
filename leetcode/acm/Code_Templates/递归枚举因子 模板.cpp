#include <iostream>
#include <cstring>
#include <cmath>
#include <vector>
using namespace std;


#define MAXP 65540
#define LL __int64

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
void Factorization(int n, vector <factor>& ans) {
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
			ans.push_back(f);
		}
		if(n == 1) {
			return ;
		}
	}
	// ©��֮������ ������MAXP�����������1�� 
	ans.push_back( factor(n, 1) );
}

// ��ʽ�ֽ��ݹ�ö���������� 
// ö�����ӵ�ͬʱ��ͬʱ����ÿ�����ӵ�ŷ������ 
void emunFactor(int depth, vector <factor> fact, int now, int eula) {
	if(fact.size() == depth) {
		// printf("%d %d\n", now, eula);
		return ;
	}
	factor &f = fact[depth];
	int i;
	emunFactor(depth+1, fact, now, eula);
	eula *= (f.prime - 1);
	now *= f.prime;
	for(i = 1; i <= f.count; ++i) {
		emunFactor(depth+1, fact, now, eula);
		now *= f.prime;
		eula *= f.prime;
	}
}

