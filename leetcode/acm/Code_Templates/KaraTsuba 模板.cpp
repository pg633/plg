/*
	KaraTsuba    �ݹ��㷨����Stack Overflow
	             ��Ҫת���ɵ�������ʽ
*/

#include <iostream> 
#include <cstdio>
#include <cstring>
#include <memory.h>

using namespace std;

const unsigned int MAXDIGITS = 1000100;      // ������λ������ 10^MAXDIGITS
const unsigned int MAXN = 9999;             // ÿ��a[i]��ʾ���������  
const unsigned int DLEN = 4;                // MAXN�����λ�� 

#define MAXL ((MAXDIGITS + DLEN - 1) / DLEN + 1)

class BigNum {
public :
    int a[MAXL];
	int len;

	void reset() {
		memset(a, 0, sizeof(a));
	}
	BigNum() {
		reset();
		len = 1;
	}
    BigNum(const int b);
    BigNum(const char * buffer);
    BigNum(const BigNum & T);

	~BigNum() {
	}
	int digitCount() const;
    void Attach(const char * buffer);
    bool Bigger(const BigNum &) const;
	void Partial(int basePower, BigNum& high, BigNum& low) const;
	void trimLeadingZero();
    BigNum & operator=(const BigNum &);
    BigNum & Add(const BigNum &);
    BigNum & Sub(const BigNum &);
	BigNum pow(BigNum n, int p) const;
    BigNum operator+(const BigNum &) const;
    BigNum operator-(const BigNum &) const;
    BigNum operator*(const BigNum &) const;
    BigNum operator/(const int &) const;
	BigNum KaraTsuba(const BigNum &) const;
    void Print() const;
};

BigNum::BigNum(const int b) {
	reset();
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
	reset();
    Attach(buffer);
}

int BigNum::digitCount() const {
	int tot = DLEN*(len-1);
	int v = a[len-1];
	if(v == 0) {
		// �������������0������λ��Ϊ1λ
		return 1;
	}
	while(v) {
		++tot;
		v /= 10;
	}
	return tot;
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
    trimLeadingZero();
}

BigNum::BigNum(const BigNum & T) : len(T.len)
{
	reset();
    memcpy(a, T.a, sizeof(a));
}

// �������ֽ�� high*10^basePower + low
// ע�⣡����Ϊ�����Ч�ʣ�basePower������DLEN�ı���
void BigNum::Partial(int basePower, BigNum& high, BigNum& low) const {
	int i, j;
	if(basePower/DLEN >= len) {
		basePower = len*DLEN;
	}

	// ��λ���low
	low = *this;
	low.len = basePower / DLEN;
	if(len == 0) low = 0;
	low.trimLeadingZero();

	// ��λ���high
	high.len = len - (basePower / DLEN);
	for(i = high.len-1, j = len-1; i >= 0; --i, --j) {
		high.a[i] = a[j];
	}
	if(high.len == 0) high = 0;
	
	//low.Print();
	//high.Print();
}

void BigNum::trimLeadingZero() {
	while(len>1 && a[len - 1] == 0) --len;
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
	if(this == &n) {
		return *this;
	}
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
    trimLeadingZero();
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
    ret.trimLeadingZero();
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
    ret.trimLeadingZero();
    return ret;
}

BigNum BigNum::pow(BigNum n, int p) const {
	BigNum ret = 1, n2 = n;
	while(p) {
		if(p & 1) {
			ret = ret * n2;
		}
		n2 = n2 * n2;
		p >>= 1;
	}
	return ret;
}

BigNum BigNum::KaraTsuba(const BigNum &other) const {
	int mcnt = digitCount();
	int ocnt = other.digitCount();
	int cnt = mcnt > ocnt ? mcnt : ocnt;
	int minCnt = mcnt < ocnt ? mcnt : ocnt;
	
	if(minCnt <= DLEN) {
		return (*this) * other;
	}
	cnt /= 2;
	while(cnt % DLEN) ++cnt;

	BigNum A, B, C, D;
	Partial(cnt, A, B);
	other.Partial(cnt, C, D);
	return A.KaraTsuba(C).KaraTsuba(this->pow(10, cnt*2)) 
		+ (A.KaraTsuba(D) + B.KaraTsuba(C)).KaraTsuba(this->pow(10, cnt))
		+ B.KaraTsuba(D);
}

void BigNum::Print() const {
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

char str[2][100010];

int main() {
	while( scanf("%s %s", str[0], str[1]) != EOF ) {
		BigNum A(str[0]);
		A.KaraTsuba(str[1]).Print();
	}
	return 0;
}

/*
34587923579243525 4233534545353345345
*/