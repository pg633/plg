#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
#include <stack>

#define MAXN 4010
#define MAXE 2000010
 
using namespace std;

enum eColorType {
	COLOR_UNDEF = 0,
	COLOR_RED = 1,
	COLOR_BLUE = 2,
};

enum eSCCAlgorithmType {
	ESCCA_KOSARAJU = 0,
	ESCCA_TARJAN = 1,
};

class Edge {
public:
	int toVertex;
	Edge* next;

	Edge() {}
	void reset(int _to, Edge* _next) {
		toVertex = _to;
		next = _next;
	}
};
typedef Edge* EdgePtr;

class Graph {
	EdgePtr *head;
	Edge *edges;
	int edgeCount;
	int vertexCount;

	int *stack, stackTop;
	bool *inStack;

	int *visited;
	int *inDeg, *outDeg;

	void doPostOrderTraversal(int u, int *order, int &orderCount);
	void doPreOrderTraversal(int u, int *sccID, int &sccCount);
	void doTarjanTraversal(int u, int *dfn, int *low, int &dfnCount, int *sccID, int &sccCount);
public:


	Graph() {
		// ��ʽǰ���� �洢
		// �ڽӱ��׽��
		head = new EdgePtr[MAXN];
		// ���ڴ��
		edges = new Edge[MAXE];
		// ����ʱ����¼�����Ƿ񱻷���
		visited = new int[MAXN];
		// ����ʱ��ջ�ṹ
		stack = new int[MAXN];
		inStack = new bool[MAXN];
		// ��� + ����
		inDeg = new int[MAXN];
		outDeg = new int[MAXN];
	}

	~Graph() {
		delete [] edges;
		delete [] head;
 		delete [] visited;
		delete [] stack;
		delete [] inStack;
		delete [] inDeg;
		delete [] outDeg;
	}

	void init(int vCount);
	void addEdge(int from, int to);
	Edge* getHead(int vertex);
	int getVertexCount();
	
	int getInDegree(int vertex);
	void subInDegree(int vertex);

	////////������� - ��¼ʱ���//////////
	void postOrderTraversal(int *order, int &orderCount);
	////////ǰ����� - ��¼ǿ��ͨ//////////
	void preOrderTraversal(int *order, int orderCount, int *sccID, int &sccCount);

	////////Tarjan�㷨�ı���///////////////
	void tarjanTraversal(int *dfn, int *low, int &dfnCount, int *sccID, int &sccCount);
	//////// ��ͼ //////////
	void doShrink(Graph* orgGraph, int *sccID, int sccCount, bool inverted);
};

void Graph::init(int vCount) {
	vertexCount = vCount;
	edgeCount = 0;
	stackTop = 0;
	for(int i = 0; i < vCount; i++) {
		head[i] = NULL;
		visited[i] = 0;
		inStack[i] = false;
		inDeg[i] = 0;
		outDeg[i] = 0;
	}
}

void Graph::addEdge(int from, int to) {
	edges[edgeCount].reset(to, head[from]);
	head[from] = &edges[edgeCount++];
	++ inDeg[to];
	++ outDeg[from];
}

Edge* Graph::getHead(int vertex) {
	return head[vertex];
}

int Graph::getVertexCount() {
	return vertexCount;	
} 

int Graph::getInDegree(int vertex) {
	return inDeg[vertex];
}

void Graph::subInDegree(int vertex) {
	--inDeg[vertex];
}
	
void Graph::doPostOrderTraversal(int u, int *order, int &orderCount) {
	if(visited[u]) {
		return;
	}
	visited[u] = 1;
	for(Edge *e = head[u]; e; e = e->next) {
		doPostOrderTraversal(e->toVertex, order, orderCount);
	}
	order[orderCount++] = u;
}

void Graph::postOrderTraversal(int *order, int &orderCount) {
	for(int i = 0; i < vertexCount; ++i) {
		doPostOrderTraversal(i, order, orderCount);
	}
}

void Graph::doPreOrderTraversal(int u, int *sccID, int &sccCount) {
	if(visited[u]) {
		return;
	}
	visited[u] = 1;
	sccID[u] = sccCount;
	for(Edge *e = head[u]; e; e = e->next) {
		doPreOrderTraversal(e->toVertex, sccID, sccCount);
	}
}

void Graph::preOrderTraversal(int *order, int orderCount, int *sccID, int &sccCount) {
	for(int i = orderCount-1; i >= 0; --i) {
		int u = order[i];
		if(visited[u]) {
			continue;
		}
		doPreOrderTraversal(u, sccID, sccCount);
		++ sccCount;
	}
}

void Graph::doTarjanTraversal(int u, int *dfn, int *low, int &dfnCount, int *sccID, int &sccCount) {
	// 1.��¼��ǰ���ʽ��u��ʱ��������ҽ�����ջ
	dfn[u] = low[u] = dfnCount++;
	stack[stackTop++] = u;
	inStack[u] = true;

	// 2.�������к�u���ӵı�(u->v)
	for(Edge *e = getHead(u); e; e = e->next) {
		int v = e->toVertex;
		if(!visited[v]) {
			// 3.������v��δ���ʣ������ѷ��ʣ��ݹ����v
			visited[v] = 1;
			doTarjanTraversal(v, dfn, low, dfnCount, sccID, sccCount);
			// 4.v�ܹ����ʵ���ʱ�������Ľ�㣬�����low[u]
			if(low[v] < low[u]) {
				low[u] = low[v];
			}
		}else if(inStack[v]) {
			// 5.v��ջ�У�˵���ڱ��η����У�vΪu������
			// �������v��ʱ�������u�������u��ʱ���
			if(dfn[v] < low[u]) {
				low[u] = dfn[v];
			}
		}
	}

	// 6.��u�ܹ�׷�ݵ�����Сʱ�������������
	//   ˵�����Ǹ�ǿ��ͨ���������ĸ���㣬ջ�е�Ԫ������ͬһ��ǿ��ͨ����
	if(dfn[u] == low[u]) {
		while(stackTop) {
			int v = stack[--stackTop];
			inStack[v] = false;
			sccID[v] = sccCount;
			if(v == u) {
				break;
			}
		}
		++ sccCount;
	}
}

void Graph::tarjanTraversal(int *dfn, int *low, int &dfnCount, int *sccID, int &sccCount) {
	stackTop = 0;
	for(int i = 0; i < vertexCount; i++) {
		if(!visited[i]) {
			visited[i] = 1;
			doTarjanTraversal(i, dfn, low, dfnCount, sccID, sccCount);
		}
	}
}

void Graph::doShrink(Graph* orgGraph, int *sccID, int sccCount, bool inverted) {
	init(sccCount);
	for(int i = 0; i < orgGraph->vertexCount; i++) {
		int from = sccID[i];
		for(Edge *e = orgGraph->getHead(i); e; e = e->next) {
			int to = sccID[e->toVertex]; 
			if(from != to) {
				if(inverted) {
					addEdge(to, from);
				}else {
					addEdge(from, to);
				}
			}
		}
	}
}

class GraphEx {

	// ԭͼ����ͼ
	Graph *orgGraph, *invGraph;
	// ������ͼ��һ�㽨����ͼ������������ 
	Graph *shrinkGraph;
	// �㷨����
	eSCCAlgorithmType esccaType;

	void buildSCCVertex();
	void clearSCCVertex();
	void addSCCVertex(int sccID, int vertexID);

	void Kosaraju();
	void Tarjan();
	void doColorFloodFill(Graph *g, int u, eColorType color);
	void doTopological(Graph* g);
public:
	// ����Kosaraju�㷨��¼���������˳��
	int *order, orderCount;
	// ����Tarjan�㷨��¼ʱ���
	int *dfn, *low, dfnCount;

	int *sccID, sccCount;
	
	// ��¼ǿ��ͨ
	EdgePtr *sccHead;
	Edge *sccVertex;
	int sccVertexCount;
	
	eColorType *vertexColor;
	int *result, resultCount;

	GraphEx() {
		orgGraph = new Graph;
		invGraph = new Graph;
		shrinkGraph = new Graph;

		// ��������ʱȾɫ��
		vertexColor = new eColorType[MAXN];
		// ��¼ͬһ��ǿ��ͨ������ԭͼ�ĵ�
		sccHead = new EdgePtr[MAXN];
		sccVertex = new Edge[MAXE];
		// Kosaraju - ���������¼�ķ���˳��
		order = new int[MAXN];
		// Tarjan - ʱ���
		dfn = new int[MAXN];
		// Tarjan - low����
		low = new int[MAXN];
		// ǿ��ͨ���ӳ��
		sccID = new int[MAXN];
		// ������������
		result = new int[MAXN]; 
	}
	
	~GraphEx() {
		delete orgGraph;
		delete invGraph;
		delete shrinkGraph;

		delete [] vertexColor;
		delete [] sccHead;
		delete [] sccVertex;
		
		delete [] dfn;
		delete [] low;
		delete [] order;
		delete [] sccID;
		delete [] result;
	}
	
	void init(int vCount, eSCCAlgorithmType et);
	void addEdge(int from, int to);
	int getOppsiteVertex(int v);
	bool SAT();

	static GraphEx& Instance() {
		static GraphEx inst;
		return inst; 
	}
};
void GraphEx::init(int vCount, eSCCAlgorithmType et) {
	orderCount = 0;
	sccCount = 0;
	esccaType = et;
	orgGraph->init(vCount);
	if(esccaType == ESCCA_KOSARAJU)
		invGraph->init(vCount);
}

void GraphEx::addEdge(int from, int to) {
	//printf("%d -> %d\n", from, to);
	orgGraph->addEdge(from, to);
	if(esccaType == ESCCA_KOSARAJU)
		invGraph->addEdge(to, from);
}

void GraphEx::buildSCCVertex() {
	// ��sccID����scc����
    clearSCCVertex();
	for(int i = 0; i < orgGraph->getVertexCount(); ++i) {
		addSCCVertex(sccID[i], i);
	}
}

void GraphEx::clearSCCVertex() {
	sccVertexCount = 0;
	for(int i = 0; i < orgGraph->getVertexCount(); ++i) {
		sccHead[i] = NULL;
	}
}

void GraphEx::addSCCVertex(int sccID, int vertexID) {
	sccVertex[sccVertexCount].reset(vertexID, sccHead[sccID]);
	sccHead[sccID] = &sccVertex[sccVertexCount++];
}

void GraphEx::Kosaraju() {
	// �Է�ͼ��һ�κ������
	invGraph->postOrderTraversal(order, orderCount);
	// ���պ�����������ԭͼ
	orgGraph->preOrderTraversal(order, orderCount, sccID, sccCount);
}

void GraphEx::Tarjan() {
	orgGraph->tarjanTraversal(dfn, low, dfnCount, sccID, sccCount);
}

int GraphEx::getOppsiteVertex(int v) {
	int p = v & 1;
	int q = v >> 1;
	return q << 1 | (1-p);
}

void GraphEx::doColorFloodFill(Graph *g, int u, eColorType color) {
	if(vertexColor[u] != COLOR_UNDEF) {
		return ;
	}
	vertexColor[u] = color;
	for(Edge *e = g->getHead(u); e; e = e->next) {
		doColorFloodFill(g, e->toVertex, color);
	}
}

void GraphEx::doTopological(Graph* g) {
	int i;
	queue <int> Q;
	// 1.��ʼ�����ж�����ɫ����Ϊ��δ����ɫ��
	// 2.���������Ϊ0�Ķ��������� 
	for(i = 0; i < g->getVertexCount(); ++i) {
		vertexColor[i] = COLOR_UNDEF;
		if(!g->getInDegree(i)) {
			Q.push(i);
		}
	}
	
	while(!Q.empty()) {
		int u = Q.front();
		Q.pop();
		// 3.���ĳ��������ɫδ���壬����Ⱦ�ɡ���ɫ�� 
		if(vertexColor[u] != COLOR_UNDEF) {
			continue;
		}
		vertexColor[u] = COLOR_RED; 
		// 4.�����кͺ�ɫ�����Ķ������������Ⱦ�ɡ���ɫ�� 
		for(Edge *vPtr = sccHead[u]; vPtr; vPtr = vPtr->next) {
			int ov = getOppsiteVertex(vPtr->toVertex);
			doColorFloodFill(g, sccID[ov], COLOR_BLUE);
		}
		// 5.����ɫ���ܹ�����ĵ�ı�ȥ����Ȼ�����Ϊ0�ĵ������У�����������ģ� 
		for(Edge *ePtr = g->getHead(u); ePtr; ePtr = ePtr->next) {
			int v = ePtr->toVertex;
			g->subInDegree(v);
			if(!g->getInDegree(v)) {
				Q.push(v);	
			}
		}
	}
	
	// 6.�����к�ɫ��������������� 
	resultCount = 0;
	for(i = 0; i < g->getVertexCount(); ++i) {
		if(vertexColor[i] == COLOR_RED) {
			for(Edge *vPtr = sccHead[i]; vPtr; vPtr = vPtr->next) {
				result[ resultCount++ ] = vPtr->toVertex;
			}
		}
	}
}

bool GraphEx::SAT() {

	if(esccaType == ESCCA_KOSARAJU)
		Kosaraju();
	else if(esccaType == ESCCA_TARJAN)
		Tarjan();

	// ��ҪԼ�� 2i �� 2i+1 �Ƕ�����
	// ����A = 2i��A' = 2i+1 
	for(int i = 0; i < orgGraph->getVertexCount(); i += 2) {
		// A �������Ƶ���A'����������ʵ���� 
		if(sccID[i] == sccID[i+1]) {
			return false;
		}
	}
	// ����ǿ��ͨ����
	//buildSCCVertex();
	// ����ԭͼ������ͼ������ + ���㣩 ��invertedΪTrue��ʾ����ͼ
	//shrinkGraph->doShrink(orgGraph, sccID, sccCount, true);
	// ��������
	//doTopological(shrinkGraph);
	return true;
}
