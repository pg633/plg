/*
����Ӿ���
    ͳ�����ľ��Σ�����þ����ڲ�ȫΪ1
    1���Ծ����ÿ��Ϊ��׼�ߣ�ͳ�����ӻ�׼�ߵ����߶ȣ�
	2��ͳ�ƻ�׼���Ϸ��������������ȡ����߼�Ϊ����Ӿ���
	3��ÿ����׼���Ϸ������������� �������ھ�ɨ�跨��
Author: WhereIsHeroFrom
Update Time: 2018-3-22
Algorithm Complexity: O(nm)
*/

#include <iostream>

using namespace std;

#define MAXN 100010
int n;

int L[MAXN], R[MAXN];
int getLargetRectangle(int n, int *heights) {
	int i;
	int Max = 0;
	heights[0] = heights[n+1] = -1;
	for(i = 1; i <= n; ++i) {
		int l = i-1;
		// 1.�����ҵ���һ���߶�С������
		while(heights[l] >= heights[i]) {
			l = L[l];
		}
		L[i] = l;
	}
	for(i = n; i >= 1; --i) {
		int r = i+1;
		// 2.�����ҵ���һ���߶�С������
		while(heights[r] >= heights[i]) {
			r = R[r];
		}
		R[i] = r;
		
		// 3.�����Ե�ǰ�߶�Ϊ��͸߶ȵ����������
		int v = heights[i] * (R[i] - L[i] - 1);
		if(v > Max) 
			Max = v;
	}
	return Max;
}

#define MAX_MATRIX 1010
// ͳ�����ľ��Σ�����þ����ڲ�ȫΪ1
// �Ծ����ÿ��Ϊ��׼�ߣ�ͳ�ƻ�׼���Ϸ��������������ȡ����߼�Ϊ����Ӿ���
int getMaxMatrix(int r, int c, int mat[MAX_MATRIX][MAX_MATRIX]) {
	int i, j;
	int Max = 0;
	for(i = 1; i <= r; ++i) {
		for(j = 1; j <= c; ++j) {
			if(mat[i][j]) {
				mat[i][j] = mat[i-1][j] + 1;
			}
		}
		int v = getLargetRectangle(c, mat[i]);
		if(v > Max) Max = v;
	}
	return Max;
}
