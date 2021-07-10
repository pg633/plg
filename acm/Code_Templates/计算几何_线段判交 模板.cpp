#include <iostream>
#include <cmath>
using namespace std;

#define eps 1e-6
#define LL __int64
typedef double Type;

// ��ֵ����
int threeValue(Type d) {
    if(fabs(d) < 1e-6)
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
    Type x, y;

public:
	Point2D(){
	}
	Point2D(Type _x, Type _y): x(_x), y(_y) {}
	void read() {
		scanf("%lf %lf", &x, &y);
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
	Type X(const Point2D& other) {
		return x*other.y - y*other.x;
	}
};

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

Segment2D seg[1100];

int main() {
	int i, j, n, cnt;
	while( scanf("%d",&n) != EOF && n) {
		for(i = 0; i < n; ++i) {
			seg[i].read();
		}
        cnt = 0;
        for(i = 0; i < n; i++) {
			for(j = i+1; j < n; ++j) {
				if(seg[i].segCross(seg[j]) != SCT_NONE) {
					++cnt;
				}
			}
        }
        printf("%d\n",cnt);
    }
}