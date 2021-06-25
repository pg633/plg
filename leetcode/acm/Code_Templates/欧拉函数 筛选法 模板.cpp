/*
ŷ������-ɸѡ��
    n�ֽ������ӱ�ʾΪn = p1^e1 * p2^e2 * ... * pk^ek
    ��n��ŷ������Ϊ f(n) = (p1-1)p1^(e1-1) * (p2-1)p2^(e2-1) * ... * (pk-1)pk^(ek-1)
	                    = n * (1-1/p1) * (1-1/p2) * ... * (1-1/pk)
	��������ɸѡ��Ԥ����˳�����f(n)��
Author: WhereIsHeroFrom
Update Time: 2018-3-21
Algorithm Complexity: O(nk)
*/

#include <iostream>
#include <vector>
using namespace std;

const int MAX_NUMBER = 10000010;
const int MAXP = 3163;                // (int)(sqrt(MAX_NUMBER*1.0) + 1);
#define LL long long

bool notprime[MAX_NUMBER];
int primes[MAXP];
int eula[MAX_NUMBER];

void eulaFilter() {
	int i, j;
	notprime[1] = 1;
	eula[1] = 1;

	// 1.ö��ÿ����
	for(i = 2; i < MAX_NUMBER; ++i) {
		if(!notprime[i]) {
			// 2.����i��ŷ������i-1
			eula[i] = i-1;
			if(i < MAXP) {
				primes[ ++primes[0] ] = i;
			}
			for(j = i+i; j < MAX_NUMBER; j += i) {
				notprime[j] = 1;
				// 3.��������ŷ������Ϊ����*��������(1-1/i)�ĳ˻�
				if(!eula[j]) eula[j] = j;
				eula[j] = eula[j]/i*(i-1);
			}
		}
	}
}
