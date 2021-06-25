#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

#define inf -100000000
#define MAXN 1010
#define MAXNODES (MAXN*30) 

// ��ֵ��Ϣ 
struct dataInfo {
	int x, y;
	int val;
	dataInfo() {
		x = y = val = inf;
	}
	dataInfo(int _x, int _y, int _val) : x(_x), y(_y), val(_val) {
	}
	void update(dataInfo &d) {
		if(d.val > val) {
			*this = d;
		}
	}

	// ��ǰֵ�ȴ���ֵ���� 
	bool isOptimal(const dataInfo &d) {
		return val >= d.val;
	} 
};

// �����������Ϣ
struct treeNode {
	treeNode *son[4];
	dataInfo data;
	treeNode() {
		reset();
	}
	void reset() {
		son[0] = son[1] = son[2] = son[3] = NULL;
		data = dataInfo(inf, inf, inf);
	}
	void update(dataInfo &d) {
		data.update(d);
	}
};
typedef treeNode* treeNodePtr;

// ������ 
struct Interval {
    int l, r;
    Interval() {}
    Interval(int _l, int _r): l(_l), r(_r) {}
    int mid();                                       // �����е� 
    int len();                                       // ���䳤�� 
    Interval left();                                 // ������� 
    Interval right();                                // �Ұ����� 
    bool isIntersectWith( const Interval& other );   // �����н�
    bool isInclude( const Interval& other );         // �����а���
    bool isInclude(int v);
};

int Interval::mid() {
    return (l + r) >> 1;
}
int Interval::len() {
    return r - l + 1;
}
Interval Interval::left() {
    return Interval(l, mid());
}
Interval Interval::right() {
    return Interval(mid()+1, r);
}
bool Interval::isIntersectWith( const Interval& other ) {
    return !( l > other.r || r < other.l );
} 
bool Interval::isInclude( const Interval& other ) {
    return l <= other.l && other.r <= r;
}
bool Interval::isInclude(int v) {
    return l <= v && v <= r;
}
    
class segTree2D {
	treeNodePtr root;
	treeNodePtr nodes;
	int nodeCount;	
	Interval xBound, yBound;

	treeNodePtr getNode();
	void insert(treeNodePtr& root, Interval xInt, Interval yInt, dataInfo insertVal);
	void query(treeNodePtr root, Interval xQry, Interval yQry, Interval xInt, Interval yInt, dataInfo& ansVal);
public:
	segTree2D() {
		nodes = new treeNode[MAXNODES];
	}
	~segTree2D() {
		delete [] nodes;
	}

	void build_tree(Interval xBnd, Interval yBnd);                     // ����߽� 
	void insert_tree(dataInfo insertVal);                              // �������� 
	void query_tree(Interval xQry, Interval yQry, dataInfo& ansVal);   // ѯ��������ֵ 
	
	
};

treeNodePtr segTree2D::getNode() {
	treeNodePtr p = &nodes[nodeCount++];
	p->reset();
	return p;
}

void segTree2D::insert(treeNodePtr& root, Interval xInt, Interval yInt, dataInfo insertVal) {
	// ����λ�ò��ڸþ��������� 
	if( !xInt.isInclude(insertVal.x) || !yInt.isInclude(insertVal.y) ){
		return ;
	}
	// ���δ���壬��˵���ڴ�֮ǰû�в�����ؽ�㣬�����½�� 
	if( root == NULL ) {
		root = getNode();
	}
	// ���µ�ǰ�������ֵ��Ϣ 
	root->update(insertVal);
	
	// Ҷ�ӽ�� 
	if( xInt.len() == 1 && yInt.len() == 1) {
		return ;
	}
	// �ݹ��ӽ�� 
	insert(root->son[0], xInt.left(),   yInt.left(), insertVal);
	insert(root->son[1], xInt.right(),  yInt.left(), insertVal);
	insert(root->son[2], xInt.left(),  yInt.right(), insertVal);
	insert(root->son[3], xInt.right(), yInt.right(), insertVal);
} 

void segTree2D::query(treeNodePtr root, Interval xQry, Interval yQry, Interval xInt, Interval yInt, dataInfo& ansVal) {
	// ѯ������ �� ��ǰ��������ʾ�����޽�����ֱ�ӷ���
	if( !xQry.isIntersectWith(xInt) || !yQry.isIntersectWith(yInt) ) {
		return ;
	}
	// ��ǰ�����δ��ʼ����˵����������Ȼû������ 
	if( root == NULL ) {
		return ;
	}

	// ��Ҫ��֦������ ��ǰֵ��������������ֵ������Ҫ�������±��� 
	if(ansVal.isOptimal(root->data)) {
		return ;
	}
	
	// ������ȫ������ֱ�Ӹ�����ֵ�������� 
	if(xQry.isInclude(xInt) && yQry.isInclude(yInt)) {
		ansVal.update( root->data );
		return ;
	}
	// �ݹ��ӽ�� 
	query(root->son[0], xQry, yQry, xInt.left(),   yInt.left(), ansVal);
	query(root->son[1], xQry, yQry, xInt.right(),  yInt.left(), ansVal);
	query(root->son[2], xQry, yQry, xInt.left(),  yInt.right(), ansVal);
	query(root->son[3], xQry, yQry, xInt.right(), yInt.right(), ansVal);
}

void segTree2D::build_tree(Interval xBnd, Interval yBnd) {
	nodeCount = 0;
	root = NULL;
	xBound = xBnd;
	yBound = yBnd;
}

void segTree2D::insert_tree(dataInfo insertVal) {
	insert(root, xBound, yBound, insertVal);
}

void segTree2D::query_tree(Interval xQry, Interval yQry, dataInfo& ansVal) {
	query(root, xQry, yQry, xBound, yBound, ansVal);
} 


