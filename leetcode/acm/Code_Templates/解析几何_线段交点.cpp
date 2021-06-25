#include <iostream>
#include <cmath>
using namespace std;

#define eps 1e-6
#define LL __int64
typedef LL Type;

Type GCD(Type a, Type b) {
	return b==0? a: GCD(b, a%b);
}

// ��ֵ����
int threeValue(Type d) {
    if(d == 0)
		return 0;
	return d > 0 ? 1 : -1;
}

// ���߶ν�������
enum SegCrossType {
	SCT_NONE = 0,
	SCT_CROSS = 1,      // �����ཻ
	SCT_ENDPOINT_ON = 2,   // ����һ���߶εĶ˵�����һ����
};

class Point2D {
public:
    Type x, y;
	Point2D(){
	}
	Point2D(Type _x, Type _y): x(_x), y(_y) {}
	void read() {
		int in_x, in_y;
		scanf("%d %d", &in_x, &in_y);
		x = in_x;
		y = in_y;
	}
	bool operator==(const Point2D& other) const {
		return x == other.x && y == other.y;
	}
	Point2D operator+(const Point2D& other) const {
		return Point2D(x + other.x, y + other.y);
	}
	Point2D operator-(const Point2D& other) const {
		return Point2D(x - other.x, y - other.y);
	}
	// !!!!ע��!!!!
	// ���TypeΪint����˷����ܵ���int32�����С�Ľ���
	Type operator*(const Point2D& other) const {
		return x*other.x + y*other.y;
	}
	Type X(const Point2D& other) const {
		return x*other.y - y*other.x;
	}
};

typedef Point2D Vector2D;

class Segment2D {
public:
	// s.x < t.x || s.x == t.x && s.y < t.y 
	Point2D s, t;

	void read() {
		s.read();
		t.read();

		if(s.x > t.x) {
			Point2D tmp = s; s = t; t= tmp;
		}
		if(s.x == t.x) {
			if(s.y > t.y) {
				Point2D tmp = s; s = t; t = tmp;
			}
		}
	}
	
	Vector2D vector() const {
		return t - s;
	}

	// ���߶ι��߲����ཻ�������
	// ȷ���� �˵��ཻ ���� ��㸲��
	bool getCrossEnd(const Segment2D& other, Point2D& ansPt) {
		if(s.x == t.x) {
			// �Ƚ�y����
			if( t.y == other.s.y ) {
				ansPt = t;
				return true;
			}
			if(s.y == other.t.y ) {
				ansPt = s;
				return true;
			}
		}else {
			// �Ƚ�x����
			if( t.x == other.s.x ) {
				ansPt = t;
				return true;
			}
			if(s.x == other.t.x ) {
				ansPt = s;
				return true;
			}
		}
		return false;
	}

	// ������
	// �ⲿ��һ��p��Ȼ����� (p-s)��(t-s)
	Type cross(const Point2D& p) const {
		return (p - s).X(t - s);
	}

	// ��������
	// ����ǰ�߶���Ϊһ���ܳ���ֱ�ߣ�����߶�other�Ƿ����������ֱ�ߵ�����
	bool lineCross(const Segment2D& other) const;
	
	// ���Ƿ����߶���
	bool pointOn(const Point2D& p) const;

	// �߶��н�
	// 1.ͨ����������
	// 2.���Ƿ����߶���
	SegCrossType segCross(const Segment2D& other);
};

bool Segment2D::lineCross(const Segment2D& other) const {
	return threeValue(cross(other.s)) * threeValue(cross(other.t)) == -1;
}

bool Segment2D::pointOn(const Point2D& p) const {
	// ��������������
	//  1.���Ϊ0��    (p-s)��(t-s) == 0
	//  2.���Ϊ-1��0��(p-s)*(p-t) <= 0
	return cross(p) == 0 && (p-s)*(p-t) <= 0;
}

SegCrossType Segment2D::segCross(const Segment2D& other) {
	if(this->lineCross(other) && other.lineCross(*this)) {
		// ���ο��������������Ȼ�ཻ��һ��
		return SCT_CROSS;
	}
	// ����һ���߶ε�ĳ���˵��Ƿ�������һ���߶��ϣ��������
	if(pointOn(other.s) || pointOn(other.t) ||
		other.pointOn(s) || other.pointOn(t) ) {
			return SCT_ENDPOINT_ON;
	}
	return SCT_NONE;
}

class fraction {
public:
	// ���� = u/d
	Type u, d;
	
	fraction() {}
	fraction(Type _u, Type _d) {
		Type g = GCD(_u, _d);
		u = _u / g;
		d = _d / g;
		if(d < 0) {
			u *= -1;
			d *= -1;
		}
	}
	void Print(char c) {
		printf("%I64d", u);
		if(d != 1) {
			printf("/%I64d", d);
		}
		printf("%c", c);
	}
};

class line2DTriple {
public:
	// ax + by + c = 0;
	Type a, b, c;
	void getFromSegment2D(const Segment2D&);
	void getCrossPoint(const line2DTriple& otherLine, fraction& X, fraction& Y);

	fraction getXByY(fraction Y) const;

	void Print() {
		printf("%I64dx + %I64dy + %I64d = 0\n", a, b, c);
	}
};

void line2DTriple::getFromSegment2D(const Segment2D& seg) {
	Vector2D v = seg.vector();
	a = - v.y;
	b = v.x;
	c = seg.s.X(seg.t);

	Type g = GCD(a, b);
	if(c % g == 0) {
		a /= g;
		b /= g;
		c /= g;
	}

	//Print();
}

fraction line2DTriple::getXByY(fraction Y) const {
	return fraction(Y.d*c + Y.u*b, -Y.d*a);
}

void line2DTriple::getCrossPoint(const line2DTriple& otherLine, fraction& X, fraction& Y) {
	if(a == 0) {
		Y = fraction(-c, b);
	}else {
		// ��ȷ�� this->a �� otherLine->a ������0
		Y = fraction(- otherLine.c*a + c*otherLine.a, otherLine.b*a - b*otherLine.a);
	}	
	X = otherLine.getXByY(Y);
}

void solve(Segment2D& A, Segment2D& B) {
	SegCrossType scType = A.segCross(B);
	Vector2D Zero(0, 0);

	// 0����
	if(scType == SCT_NONE) {
		printf("0\n");
		return ;
	}
	// ������
	if (scType == SCT_ENDPOINT_ON) {
		// �������㣬���ཻ
		// A��B���==0������ƽ��
		// �ཻ + ƽ�� = ����
		if(threeValue(A.vector().X(B.vector())) == 0) {
			Point2D p;
			int ans = -1;
			if( A.vector() == Zero ) {
				p = A.s;
				ans = 1;
			}else if(B.vector() == Zero) {
				p = B.s;
				ans = 1;
			}else if( A.getCrossEnd(B, p) ) {
				ans = 1;
			}else {
				ans = -1;
			}
			if(ans == -1)
				printf("INF\n");
			else {
				printf("%d\n%I64d %I64d\n", ans, p.x, p.y);
			}
			return ;
		}
	}
	printf("1\n");
	line2DTriple LA, LB;
	LA.getFromSegment2D(A);
	LB.getFromSegment2D(B);
	fraction X, Y;
	if(LA.a == 0) {
		LA.getCrossPoint(LB, X, Y);
	}else if(LB.a == 0) {
		LB.getCrossPoint(LA, X, Y);
	}else {
		LA.getCrossPoint(LB, X, Y);
	}
	X.Print(' ');
	Y.Print('\n');
}

int main() {
	int t;
	Segment2D A, B;
	scanf("%d", &t);

	while(t--) {
		A.read();
		B.read();
		solve(A, B);
	}
	return 0;
}