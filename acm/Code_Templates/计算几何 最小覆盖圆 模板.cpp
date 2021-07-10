#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cmath>
using namespace std;

#define MAXN 1000010
#define eps 1e-6
const double PI = acos(-1.0);

class Point;
class LineEquation;

double sqr(double x) {
	return x * x;
}

struct LineEquation {
	double a, b, c;
	LineEquation() {
	}
	LineEquation(double _a, double _b, double _c) {
		a = _a; b = _b; c = _c; 
	}
	
	Point getCrossPoint(const LineEquation& other);
	double getXByY(double y) const;
};

struct Point {
	double x, y;
	Point(){}
	Point(double _x, double _y) : x(_x), y(_y) {
	}
	void read() {
		scanf("%lf %lf", &x, &y);
	}
	Point operator+(const Point& other) const {
		return Point(x + other.x, y + other.y);
	}
	Point operator-(const Point& other) const {
		return Point(x - other.x, y - other.y);
	}
	double operator*(const Point& other) const {
		return x * other.x + y * other.y;
	}
	Point operator/(double k) const {
		return Point(x/k, y/k);
	}
	double len() const {
		return sqrt(len_sqr());
	}
	double len_sqr() const {
		return sqr(x)+sqr(y);
	} 
	double dist(const Point& other) const {
		return (*this - other).len();
	}
	Point centerWith(const Point& other) const {
		return (*this + other) / 2;
	}

	double getAngle(const Point& A, const Point& B) {
		Point OA = (A-*this);
		Point OB = (B-*this);
		return acos(OA*OB/OA.len()/OB.len());
	}
	
	void print() {
		printf("%lf %lf\n", x, y);
	}
	
	Point getExcenter(const Point& A, const Point& B) {
		double agl = getAngle(A, B);
		if( fabs(agl-PI) < eps ) {
			return (A+B)/2;
		}else if( fabs(agl) < eps ) {
			return dist(A)>dist(B) ? centerWith(A) : centerWith(B);
		}
		Point OA = A - *this;
		Point OB = B - *this;
		LineEquation L1(2*OA.x, 2*OA.y, len_sqr()-A.len_sqr());
		LineEquation L2(2*OB.x, 2*OB.y, len_sqr()-B.len_sqr());
		if(fabs(L1.a) < eps) {
			return L1.getCrossPoint(L2);
		}
		return L2.getCrossPoint(L1);
	}
};

Point LineEquation::getCrossPoint(const LineEquation& other) {
	Point ans;
	if(fabs(a) < eps) {
		ans.y = -c/b;
	}else {
		ans.y = (other.a*c - a*other.c) / (a*other.b - other.a*b);
	}
	ans.x = other.getXByY(ans.y);
	return ans;
}

double LineEquation::getXByY(double y) const {
	return - (b*y + c) / a;
}

struct Circle {
	Point center;
	double radius;

	Circle(){}
	Circle(Point c, double r): center(c), radius(r) {
	}

	bool isPointInCircle(const Point& pt) {
		return (pt - center).len() <= radius;
	}
};

struct PointSet {
	int n;
	Point p[MAXN];

	// ������������������е��˳��
	void randomSuffle() {
		int i;
		for(i = 0; i < n; ++i) {
			// ����p[i]��p[ridx]
			int ridx = rand() % n;
			Point tmp = p[i];
			p[i] = p[ridx];
			p[ridx] = tmp;
		}
	}

	// ��ȡǰidx2�������С��ΧԲ(���ұ������������p[idx1]��p[idx2])
	// �����ǰ����Բ�ڣ��򲻴���
	// ���� �����Ȼ��ȷ��һ��Բ�� 
	Circle getMinSurroundCircleInclude2(int idx1, int idx2) {
		int i;
		Point nowc = (p[idx1] + p[idx2]) / 2;
		double nowr = (nowc - p[idx2]).len(); 
		Circle now(nowc, nowr);
		
		for(i = 0; i < idx1; ++i) {
			if(!now.isPointInCircle(p[i])) {
				Point nextc = p[i].getExcenter(p[idx1], p[idx2]);
				double nextr = (nextc - p[idx2]).len();
				if(nextr > nowr) {
					nowc = nextc;
					nowr = nextr;
					now = Circle(nowc, nowr);
				}				
			}
		}
		return now;
	}

	// ��ȡǰidx�������С��ΧԲ(���ұ������һ����p[idx])
	Circle getMinSurroundCircleInclude1(int idx) {
		int i;
		// 1.��һ��p[idx]ΪԲ�ģ��뾶Ϊ0��Բ 
		Circle now(p[idx], 0);

		// 2.ö��ǰidx���㣬�����i���㲻�ڵ�ǰԲ�У�������һ���µ�Բ��
		//     ���Բ���뾭��p[idx]��p[i]�����Ұ���ǰ�����е�
		for(i = 0; i < idx; ++i) {
			if(!now.isPointInCircle(p[i])) {
				now = getMinSurroundCircleInclude2(i, idx);
			}
		}
		return now;
	}
	
	// ��ȡ�㼯����С��ΧԲ
	Circle getMinSurroundCircle() {
		int i;
		// 1.������������������е��˳��
		randomSuffle();
		
		Circle now(p[0], 0);
		// 2.ö��n���㣬�����i���㲻�ڵ�ǰԲ�У�������һ���µ�Բ��
		//    ���Բ���뾭��p[i]�����Ұ���ǰ�����е�
		for(i = 1; i < n; ++i) {
			if(!now.isPointInCircle(p[i])) {
				now = getMinSurroundCircleInclude1(i);
			}
		}
		return now;
	}
};

PointSet ps;

int main() {
	int t;
	int i;
	while( scanf("%d", &ps.n) != EOF ) {
		for(i = 0; i < ps.n; ++i) {
			ps.p[i].read();
		}
		Circle c = ps.getMinSurroundCircle();
		printf("%.2lf %.2lf %.2lf\n", c.center.x, c.center.y, c.radius);
	}
	return 0;
}

/*
25
0 0 0 1 0 2 0 3 0 4
1 0 1 1 1 2 1 3 1 4
2 0 2 1 2 2 2 3 2 4
3 0 3 1 3 2 3 3 3 4
4 0 4 1 4 2 4 3 4 4
*/
