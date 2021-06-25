/*
ȫ����
	n��Ԫ�أ�����a1��a2������������an������ͬ������ȫ���У��ɵ�n!����ͬ�����С�

���ؼ�����
    ������ĳһԪ��ai�ظ���ni�Σ�ȫ�����б����ظ�Ԫ�أ�����������ͬ��������ӦΪn!/ni!��
    ͬ��a1�ظ���n1�Σ�a2�ظ���n2�Σ�����������ak�ظ���nk�Σ���n1+n2+��������+nk=n��
    ����n��Ԫ�ؽ���ȫ���У��ɵò�ͬ���еĸ�����  n!/(n1!n2!...nk!) ��

	n!/(n1!n2!...nk!) �ļ����漰�����������Ч��̫�ͣ�
    ���㷨�����������������ӷֽ⣬���Ӻͷ�ĸ�ֱ�ϲ������ӣ�Ȼ���ٽ����ӵ�������
��ȥ��ĸ�������ӡ�

Author: WhereIsHeroFrom
Update Time: 2018-3-19
Algorithm Complexity: O(nk)
*/

#include <iostream> 
#include <cstdio>
#include <cstring>
#include <vector>
#include <memory.h>

using namespace std;

const unsigned int MAXDIGITS = 10002;        // ������λ������ 10^MAXDIGITS
const unsigned int MAXN = 9999;             // ÿ��a[i]��ʾ���������  
const unsigned int DLEN = 4;                // MAXN�����λ�� 

class BigNum {
public :
    int a[(MAXDIGITS + DLEN - 1) / DLEN + 1];
    int len;
    BigNum(){len = 1; memset(a, 0, sizeof(a));}
    BigNum(const int b);
    BigNum(const char * buffer);
    BigNum(const BigNum & T);
    void Attach(const char * buffer);
    bool Bigger(const BigNum &) const;
    BigNum & operator=(const BigNum &);
    BigNum & Add(const BigNum &);
    BigNum & Sub(const BigNum &);
    BigNum operator+(const BigNum &) const;
    BigNum operator-(const BigNum &) const;
    BigNum operator*(const BigNum &) const;
    BigNum operator/(const int &) const;
    void Print();
};

BigNum::BigNum(const int b) {
    int c, d = b;
    len = 0;
    memset(a, 0, sizeof(a));
    while(d > MAXN) {
        c = d % (MAXN + 1);
        d = d / (MAXN + 1);
        a[len++] = c;
    }
    a[len++] = d;
}

BigNum::BigNum(const char * buffer) {
    Attach(buffer);
}

void BigNum::Attach(const char * buffer) {
    int i, j;
    int lst[] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    j = len = 0;
    memset(a, 0, sizeof(a));
    for(i = strlen(buffer) - 1; i >= 0; --i, ++j) {
        if(j >= DLEN) {
            j = 0;
            len++;
        }
        a[len] += lst[j] * (buffer[i] - '0');
    }
    len++;
    // ����ǰ���� 
    while(len > 1 && a[len - 1] == 0) len--;
}

BigNum::BigNum(const BigNum & T) : len(T.len)
{
    memcpy(a, T.a, sizeof(a));
}

bool  BigNum::Bigger(const BigNum & T) const {
    int ln;
    if(len > T.len) return true;
    else if(len == T.len){
        ln = len - 1;
        while(ln>=0 && a[ln] == T.a[ln]) ln--;
        if(ln >= 0 && a[ln] > T.a[ln]) return true;
        else return false;
    }
    else return false;
}

BigNum & BigNum::operator=(const BigNum & n){
    len = n.len;
    memcpy(a, n.a, sizeof(a));
    return *this;
}
BigNum & BigNum::Add(const BigNum & T){
    int i,big;
    big = T.len > len ? T.len : len;
    for(i = 0 ; i < big ; i++)
    {
        a[i] = a[i] + T.a[i];
        if(a[i] > MAXN)
        {
            a[i + 1]++;
            a[i] = a[i] - MAXN - 1;
        }
    }
    if(a[big] != 0) len = big + 1;
    else len = big;
    return *this;
}
BigNum & BigNum::Sub(const BigNum & T){
    int i,j,big;
    big = T.len > len ? T.len : len;
    for(i = 0 ; i < big ; i++)
    {
        if(a[i] < T.a[i])
        {
            j = i + 1;
            while(a[j] == 0) j++;
            a[j--]--;
            while(j > i) a[j--] += MAXN;
            a[i] = a[i] + MAXN + 1 - T.a[i];
        }
        else a[i] -= T.a[i];
    }
    len = big;
    while(len>1 && a[len - 1] == 0) len--;
    return *this;
}
BigNum BigNum::operator+(const BigNum & n) const{
    BigNum a = *this;
    a.Add(n);
    return a;
}
BigNum BigNum::operator-(const BigNum & T) const{
    BigNum b = *this;
    b.Sub(T);
    return b;
}

BigNum BigNum::operator*(const BigNum & T) const{
    BigNum ret;
    int i, j, up, temp1, temp;
    for(i = 0 ; i < len ; i++)
    {
        up = 0;
        for(j = 0 ; j < T.len ; j++)
        {
            temp = a[i] * T.a[j] + ret.a[i + j] + up;
            if(temp > MAXN)
            {
                temp1 = temp % (MAXN + 1);
                up = temp / (MAXN + 1);
                ret.a[i + j] = temp1;
            }
            else
            {
                up = 0;
                ret.a[i + j] = temp;
            }
        }
        if(up != 0) ret.a[i + j] = up;
    }
    ret.len = i + j;
    while(ret.len>1 && ret.a[ret.len - 1] == 0) ret.len--;
    return ret;
}
BigNum BigNum::operator/(const int & b) const{
    BigNum ret;
    int i,down = 0;
    for(i = len - 1 ; i >= 0 ; i--)
    {
        ret.a[i] = (a[i] + down * (MAXN + 1)) / b;
        down = a[i] + down * (MAXN + 1) - ret.a[i] * b;
    }
    ret.len = len;
    while(ret.a[ret.len - 1] == 0) ret.len--;
    return ret;
}
void BigNum::Print() {
    int i;
    char format[10];
    sprintf(format, "%%0%dd", DLEN);
    printf("%d", a[len - 1]);
    for(i = len - 2 ; i >= 0 ; i--)
    {
        printf(format, a[i]);
    }
    putchar('\n');
}


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


// return x^y
BigNum power(BigNum x, int y) {
	BigNum ret = 1;
	while(y) {
		if(y & 1) {
			ret = ret * x;
		}
		x = x * x;
		y >>= 1;
	}
	return ret;
}

// ���ؼ����� 
// items: ÿ����Ʒ������
// n = sum{ items[i] | 0<=i<items.size() }
// ����ֵ��  n! / II(items[i]!)      (II��������)
BigNum multisetPermutation(vector <int> items) {
	int i, j, n = 0;
	// ͳ���ܸ���n
	for(i = 0; i < items.size(); ++i) {
		n += items[i];
	}
	factors u;
	// ͳ�Ʒ��������е�������
	for(i = 1; i <= n; ++i) {
		u = u + Fac[i];
	}
	// ��ȥ��ĸ������������
	for(i = 0; i < items.size(); ++i) {
		for(j = 2; j <= items[i]; ++j) {
			u = u - Fac[j];
		}
	}
	//u.print();
	// ������ת���ɴ���
	BigNum ans = 1;
	for(i = 0; i < u.factorCnt; ++i) {
		ans = ans * power(u.data[i].prime, u.data[i].count);
	}
	//ans.Print();
	return ans;
}
