#include <iostream>

using namespace std;

#define LL long long
#define MAXN 100010

LL GCD(LL a, LL b) {
	return b ? GCD(b, a%b) : a;
}

// aX + bY = 1 
LL ExpGcd(LL a, LL b, LL &X, LL &Y) {
     LL q, temp;
     if( !b ) {
         q = a; X = 1; Y = 0;
         return q;
     }else {
        q = ExpGcd(b, a % b, X, Y);
        temp = X; 
        X = Y;
        Y = temp - (a / b) * Y;
        return q;
	 }
}

LL Product_Mod(LL a, LL b, LL mod) {
	LL sum = 0;
	LL flag = b >= 0?1:-1;
	if(flag < 0) {
		b = -b;
	}
	while(b) {
		if(b & 1) sum = (sum + a) % mod;
		a = (a + a) % mod;
		b >>= 1;
	}
	return (sum * flag + mod) % mod;
}

// K = m[0] * x + r[0];
// K = m[1] * y + r[1];
// K = m[2] * z + r[2];

// y = m[3] * v + r[3];


LL chineseRemain(int n, LL mod[], LL rem[]) {
    LL lcm = 1;
    int i;
    // 1. Ԥ�����������е�mod[]��rem[]��ת����������
	for(i = 0; i < n; ++i) {
		// K = x[i]*mod[i] + rem[i];     (KΪ���ս⣬x[i]Ϊδ֪��)
		// a.����ȡ�� 
		if(mod[i] < 0) {
			mod[i] = -mod[i];
		} 
		// b.����ȡ��
		rem[i] = (rem[i] % mod[i] + mod[i]) % mod[i];
	} 
    // 2.�������б�ģ������С������ 
    for(i = 0; i < n; i++) {
        LL g = GCD(lcm, mod[i]);
        lcm = lcm / g * mod[i];
    }
    // 3.�㷨������ �������ս�ΪK�� 
    //   ö�� i = 1 to n-1 
    //   1) �ϲ���ʽ(0)��(i)�� mod[0]*x[0] + rem[0]      = mod[i]*x[i] + rem[i];
    //                         mod[0]*x[0] - mod[i]*x[i] = rem[i] - rem[0];
    //                            A  *  X  +   B   * Y   = C;
    //   2) ������չŷ����ã����x[i] = Y = Y0 + A*t; 
    //   3) ��x[i]�����ʽ(i)���õ���   K = mod[0]*mod[i]*t + (rem[i]+mod[i]*Y0); 
    //   4) ���µ�ʽ(0)��    mod[0] = mod[0]*mod[i]
    //                       rem[0] = (rem[i]+mod[i]*Y0) % mod[0];
    //   5) n-1�ε�����ϣ�rem[0]������С�Ǹ������⡣ 
    LL A, B, C, X, Y;
    for(i = 1; i < n; i++) {
        A = mod[0];
        B = -mod[i];
        C = rem[i] - rem[0];
        LL g = GCD(A, B);
        if( C % g ) {
            return -1;
        }
        // ��ʽ����ͬʱ����g��-1����ʽ���� 
        A /= g, B /= g, C /= g;
        if(A < 0) {
        	// ��һ����Ϊ�˰�A��B��ת�������� 
        	A = -A, B = -B, C = -C;
        	B = ((B % A) + A) % A;
		}
        ExpGcd(A, B, X, Y);
		Y = Product_Mod(Y, C, A);
        mod[0] = A * mod[i];
        rem[0] = (rem[i] +  Product_Mod(mod[i], Y, mod[0])) % mod[0];
    }
    return rem[0];
}
 
LL m[MAXN], r[MAXN];


int main() {
    int t;
    int i;
    int n;
    while(  scanf("%d", &n) != EOF ) {
        for(i = 0; i < n; i++) {
            scanf("%I64d", &m[i]);
            scanf("%I64d", &r[i]);
        }
        printf("%I64d\n", chineseRemain(n, m, r) );    
    }
    return 0;
}

/*
3
107 1
1007 3
10007 5
796407100
*/ 
