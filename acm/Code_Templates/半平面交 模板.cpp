#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
using namespace std;

const int MAXP = 1100;
#define eps 1e-15
#define LL __int64
typedef double Type;

class HalfPlane;
class Polygon;

// ��ֵ����
int threeValue(Type d) {
    if(fabs(d) < 1e-6)
		return 0;
	return d > 0 ? 1 : -1;
}

// ���߶ν�������
enum SegCrossType {
	SCT_NONE = 0,
	SCT_CROSS = 1,         // �����ཻ
	SCT_ENDPOINT_ON = 2,   // ����һ���߶εĶ˵�����һ����
};

class Point2D {
    Type x, y;

public:
	Point2D(){
	}
	Point2D(Type _x, Type _y): x(_x), y(_y) {}
	void read() {
		scanf("%lf %lf", &x, &y);
	}
	void print() {
		printf("<%lf, %lf>\n", x, y);
	}
    Point2D turnLeft();
    Point2D turnRight();
	double angle();
	Point2D operator+(const Point2D& other) const;
	Point2D operator-(const Point2D& other) const;
	Point2D operator*(const double &k) const;
	Point2D operator/(const double &k) const;
	Type operator*(const Point2D& other) const;
    bool operator <(const Point2D &p) const;
	Type X(const Point2D& other);
	double len();
	void normalize();
};

typedef Point2D Vector2D;

double Vector2D::len() {
	return sqrt(x*x + y*y);
}

void Vector2D::normalize() {
	double l = len();
	if(threeValue(l)) {
		x /= l;
		y /= l;
	}
}

Point2D Point2D::turnLeft() {
    return Point2D(-y, x);
}
Point2D Point2D::turnRight() {
    return Point2D(y, -x);
}
double Point2D::angle() {
	return atan2(y, x);
}

Point2D Point2D::operator+(const Point2D& other) const {
	return Point2D(x + other.x, y + other.y);
}

Point2D Point2D::operator-(const Point2D& other) const {
	return Point2D(x - other.x, y - other.y);
}

Point2D Point2D::operator *(const double &k) const {
    return Point2D(x * k, y * k);
}

Point2D Point2D::operator /(const double &k) const {
    return Point2D(x / k, y / k);
}

bool Point2D::operator <(const Point2D &p) const {
    return y + eps < p.y || ( y < p.y + eps && x + eps < p.x );
}

// !!!!ע��!!!!
// ���TypeΪint����˷����ܵ���int32�����С�Ľ���
// ���
Type Point2D::operator*(const Point2D& other) const {
	return x*other.x + y*other.y;
}
// ���
Type Point2D::X(const Point2D& other) {
	return x*other.y - y*other.x;
}

class Segment2D {
	Point2D s, t;
public:
	void read() {
		s.read();
		t.read();
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

class Line2D {
public:
	Point2D a, b;
	Line2D() {}
	Line2D(const Point2D& _a, const Point2D& _b): a(_a), b(_b) {}
	Point2D getCrossPoint(const Line2D& );
	bool isParallelTo(const Line2D& );
};

// ������ƽ�е�ֱ�߱��н���
// ���ò��������������������α�ֵ�ó�����
Point2D Line2D::getCrossPoint(const Line2D& other) {
	double SA = (other.a - a).X(b - a);
	double SB = (b - a).X(other.b - a);
	return (other.b * SA + other.a * SB) / (SA + SB);
}

bool Line2D::isParallelTo(const Line2D& other) {
	return !threeValue( (b-a).X(other.b - other.a) );
}

/* ��ƽ�涨�壺
   ��������(a->b)����������涨��Ϊ��ƽ��
   ���еĶ���ν�����ʱ����Ҫע�⣬��֤�㰴����ʱ������
   �ж��Ƿ���ʱ�����п�������� >0 �ж�
*/
class HalfPlane : public Line2D {
	double angle;
public:
	HalfPlane() {}
    HalfPlane(const Point2D &_a, const Point2D& _b) {
		a = _a;
		b = _b;
		angle = (_b - _a).angle();
    }
	bool equalAngle(const HalfPlane &other) const;
	bool operator < (const HalfPlane &other) const;	
	Type X(const Point2D &p) const;
	bool isPointIn(const Point2D &p) const;
	void move(double dist);
};

class HalfPlanes {
	int n;
	HalfPlane hp[MAXP];
	void unique();

	Point2D p[MAXP];
	int que[MAXP];
	int head, tail;

	void print();
public:
	HalfPlanes() {}
	~HalfPlanes() {}
	void init();
	int size() {return n;}
	void getHalfPlane(HalfPlanes& H);
	void addHalfPlane(const HalfPlane &);
	void addRectBorder(Type lx, Type ly, Type rx, Type ry);
	bool doIntersection();
    void getConvex(Polygon &convex);

	static HalfPlanes &Instance() {
		static HalfPlanes inst;
		return inst;
	}
};

struct Polygon {
    int n;
    Point2D p[MAXP];

	void print();
	double area();
    void getConvex(Polygon &c);
    bool isConvex();
    bool isPointInConvex(const Point2D &P);
    Point2D CalcBary();
	double getPolygonIntersect(Polygon& other);
	void convertToCounterClockwise();
	int constructTriangleHalfPlane(const Point2D &A, const Point2D &B, const Point2D &C,  HalfPlane* hp);
};

void Polygon::print() {
	int i;
	printf("%d\n", n);
	for(i = 0; i < n; ++i) {
		p[i].print();
	}
}

double Polygon::area() {
    double sum = 0;
	p[n] = p[0];
    for ( int i = 0 ; i < n; i ++ )
        sum += p[i].X(p[i + 1]);
    return sum / 2;
}

// ��͹��
void Polygon::getConvex(Polygon &c) {
    sort(p, p + n);
    c.n = n;
	if(n <= 2) {
		for(int i = 0; i < n; ++i) {
			c.p[i] = p[i];
		}
		return ;
	}
        
	int &top = c.n;
    top = 1;
    for ( int i = 2 ; i < n ; i ++ ) {
        while ( top && threeValue(( c.p[top] - p[i] ).X( c.p[top - 1] - p[i] )) >= 0 )
            top --;
        c.p[++top] = p[i];
    }
    int temp = top;
    c.p[++ top] = p[n - 2];
    for ( int i = n - 3 ; i >= 0 ; i -- ) {
        while ( top != temp && threeValue(( c.p[top] - p[i] ).X( c.p[top - 1] - p[i] )) >= 0 )
            top --;
        c.p[++ top] = p[i];
    }
}

// �Ƿ�͹�����
bool Polygon::isConvex() {
    bool s[3] = { false , false , false };
    p[n] = p[0], p[n + 1] = p[1];
    for ( int i = 0 ; i < n ; i ++ ) {
        s[threeValue(( p[i + 1] - p[i] ) * ( p[i + 2] - p[i] )) + 1] = true;
		// ����������ң��϶��ǰ���
        if ( s[0] && s[2] ) return false;
    }
    return true;
}

// ���Ƿ���͹�������
bool Polygon::isPointInConvex(const Point2D &P) {
    bool s[3] = { false , false , false };
    p[n] = p[0];
    for ( int i = 0 ; i < n ; i ++ ) {
        s[threeValue(( p[i + 1] - P ) * ( p[i] - P )) + 1] = true;
        if ( s[0] && s[2] ) return false;
        if ( s[1] ) return true;
    }
    return true;
}

// ת����ʱ��˳��
void Polygon::convertToCounterClockwise() {
	if(area() >= 0) {
		return ;
	}
	for(int i = 1; i <= n / 2; ++i) {
		Point2D tmp = p[i];
		p[i] = p[n-i];
		p[n-i] = tmp;
	}
}

// �����������εĽ�
// Ҫ�������������ʱ������
double Polygon::getPolygonIntersect(Polygon& other) {
	int i, j;
	HalfPlane hp[2][3];
	Polygon g;
	
	convertToCounterClockwise();
	other.convertToCounterClockwise();

	double area = 0;
	// ö��ÿ�������Σ��ǵ�����
	for(i = 0; i < n; ++i) {
		Point2D O(0, 0);
		// ��������ηֱ����������������Σ����ƽ�潻�����ۼ�
		int td = constructTriangleHalfPlane(O, p[i], p[i+1], hp[0]);
		if(td == 0)
			continue;

		for(j = 0; j < other.n; ++j) {
			HalfPlanes &h = HalfPlanes::Instance();
			h.init();
			int flag = td * constructTriangleHalfPlane(O, other.p[j], other.p[j+1], hp[1]);
			if(flag) {
				h.addHalfPlane(hp[0][0]), h.addHalfPlane(hp[0][1]), h.addHalfPlane(hp[0][2]);
				h.addHalfPlane(hp[1][0]), h.addHalfPlane(hp[1][1]), h.addHalfPlane(hp[1][2]);

				if(h.doIntersection()) {
					h.getConvex(g);
					if( threeValue(g.area()) ) {
						area += flag * g.area();
					}
				}
			}
		}
	}
	// ע�⣡������������������ཻ �������Ϊ����
	return area;
}

int Polygon::constructTriangleHalfPlane(const Point2D &A, const Point2D &B, const Point2D &C, HalfPlane* hp) {
	int v = threeValue((B-A).X(C-A));
	if(v == 0) return 0;
	if(v < 0) {
		hp[0] = HalfPlane(A, C);
		hp[1] = HalfPlane(C, B);
		hp[2] = HalfPlane(B, A);
		return -1;
	}else {
		hp[0] = HalfPlane(A, B);
		hp[1] = HalfPlane(B, C);
		hp[2] = HalfPlane(C, A);
		return 1;
	}
}


Point2D Polygon::CalcBary() {
    Point2D ret(0, 0);
    double area = 0;
    p[n] = p[0];
    for ( int i = 0 ; i < n ; i ++ ) {
        double temp = p[i] * p[i + 1];
        if ( threeValue(temp) == 0 ) continue;
        area += temp;
        ret = ret + ( p[i] + p[i + 1] ) * ( temp / 3 );
    }
    return ret / area;
}


bool HalfPlane::equalAngle(const HalfPlane &other) const {
	return !threeValue(angle - other.angle);
}

// ���ǲ�ͬ���ռ��Ǵ�С��������
// ���������ͬ����������²�����
// ����A = (b - a) ��� ���� B = (other.a - a)
// �������0��˵������A������B���Ҳ࣬����A���޳�B��
bool HalfPlane::operator < (const HalfPlane &other) const {
	if( threeValue(angle - other.angle) ) {
		return angle < other.angle;
	}
	return !isPointIn(other.a);
}

// ��������ǳ����� ����isPointIn���ж�
// ��˽�� <= 0����˵��p���ڰ�ƽ��������
Type HalfPlane::X(const Point2D &p) const {
    return ( b - a ).X( p - a );
}

bool HalfPlane::isPointIn(const Point2D &p) const {
	return threeValue( X(p) ) >= 0;
}

// ��ƽ�濿���󷽽�����������������Ϊdist
void HalfPlane::move(double dist) {
	Point2D t = (b-a).turnLeft();
	t.normalize();
	a = a + t * dist;
	b = b + t * dist;
}

void HalfPlanes::print() {
	for(int i = 0; i < n; ++i) {
		printf("<%d>\n", i);
		hp[i].a.print();
		hp[i].b.print();
	}
}

void HalfPlanes::init() {
	n = 0;
}

void HalfPlanes::addHalfPlane(const HalfPlane & h) {
	hp[n++] = h;
}

void HalfPlanes::addRectBorder(Type lx, Type ly, Type rx, Type ry) {
	addHalfPlane( HalfPlane(Point2D(lx, ly),  Point2D(rx, ly) ));
	addHalfPlane( HalfPlane(Point2D(rx, ly),  Point2D(rx, ry) ));
	addHalfPlane( HalfPlane(Point2D(rx, ry),  Point2D(lx, ry) ));
	addHalfPlane( HalfPlane(Point2D(lx, ry),  Point2D(lx, ly) ));
}

void HalfPlanes::getHalfPlane(HalfPlanes& H) {
	for(int i = 0; i < H.size(); ++i) {
		addHalfPlane(H.hp[i]);
	}
}
void HalfPlanes::unique() {
	int m = 1;
	for(int i = 1; i < n; ++i) {
		// ������ͬȡ��ǰ
		if( !hp[i].equalAngle(hp[i-1]) ) {
			hp[m++] = hp[i];
		}
	}
	n = m;
}

bool HalfPlanes::doIntersection() {
	// 1.���ռ��������޳�������ͬ�İ�ƽ��
	sort(hp, hp + n);
	unique();
	//print();
	// 2.��ǰ������ƽ����뵥�����У����Ҽ��������
	que[ head=0 ] = 0, que[ tail=1 ] = 1;
	p[1] = hp[0].getCrossPoint(hp[1]);
	// 3.���ռ���˳������ö������ƽ�棬�Ͷ����еİ�ƽ�����������
	for(int i = 2; i < n; ++i) {
		// ǰ������ƽ�潻��p[tail]�����ڵ�ǰ��ƽ���ڣ���ɾ��ǰһ����ƽ��
		while(head < tail && !hp[i].isPointIn(p[tail]) )
			--tail;
		// �ж���һ��İ�ƽ�潻��p[head+1]�����ڵ�ǰ��ƽ���ڣ������ƽ���޳�
		while(head < tail && !hp[i].isPointIn(p[head+1]) )
			++head;
		// ���ĳ��ʱ�� ���������ƽ��ƽ���ˣ���Ȼ�޽�
		if(hp[i].isParallelTo(hp[que[tail]])) {
			return false;
		}
		// ����ǰ��ƽ��ѹ�����
		que[ ++tail ] = i;
		p[tail] = hp[i].getCrossPoint(hp[que[tail-1]]);
	}
	// 4.�����׵��Ǹ���ƽ�棬��Ҫ�������е㶼���������
	while(head < tail && !hp[que[head]].isPointIn(p[tail]))
		--tail;
	while(head < tail && !hp[que[tail]].isPointIn(p[head+1]))
		++head;
	// ����������ƽ����ܹ���һ���������
	return head + 1 < tail;
}

void HalfPlanes::getConvex(Polygon &convex) {
	p[head] = hp[que[head]].getCrossPoint(hp[que[tail]]);
    convex.n = tail - head + 1;
    for ( int j = head, i = 0 ; j <= tail; i ++, j ++ ) {
        convex.p[i] = p[j];
    }
	convex.p[ convex.n ] = convex.p[0];
}

// ��ȡ����εĺ�
// 
bool getPolygonKernel(Polygon &poly, Polygon& ansPoly, double movedist,  double& area) {
	int i;
	HalfPlanes &h = HalfPlanes::Instance();
	h.init();

	// �������0����ʱ��
	if(poly.area() > 0) {
		for(i = 0; i < poly.n; ++i) {
			HalfPlane hp(poly.p[i], poly.p[i+1]);
			hp.move(movedist);
			h.addHalfPlane(hp);
		}
	}else {
		for(i = 0; i < poly.n; ++i) {
			HalfPlane hp(poly.p[i+1], poly.p[i]);
			hp.move(movedist);
			h.addHalfPlane(hp);
		}
	}
	if( h.doIntersection() ) {
		h.getConvex(ansPoly);
		area = ansPoly.area();
		return true;
	}else {
		area = 0;
		return false;
	}
}


// ��ȡ����εĺ�
bool getPolygonKernel(double lx, double ly, double rx, double ry, Polygon &poly, HalfPlanes& planes, double& area) {
	int i;
	HalfPlanes &h = HalfPlanes::Instance();
	h.init();
	h.addRectBorder(lx, ly, rx, ry);
	h.getHalfPlane(planes);

	if( h.doIntersection() ) {
		h.getConvex(poly);
		area = poly.area();
		return true;
	}else {
		area = 0;
		return false;
	}
}

Polygon poly[2];

int main() {
	int i, j;
	while(scanf("%d %d", &poly[0].n, &poly[1].n) != EOF) {
		double tot = 0;
		for(i = 0; i < 2; ++i) {
			for(j = 0; j < poly[i].n; ++j) {
				poly[i].p[j].read();
			}
			poly[i].p[poly[i].n] = poly[i].p[0];
			tot += fabs(poly[i].area());
		}
		tot -= poly[0].getPolygonIntersect(poly[1]);
		printf("%.2lf\n", tot);
	}
	return 0;
}
