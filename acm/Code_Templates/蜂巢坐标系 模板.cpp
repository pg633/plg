/*
�䳲����ϵ ģ��
      �ǵ�ǰ���ӵı�ż�Ϊ(r, c)��
      1��������Ŀ������Ϊ2N-1���������кţ���0��ʼ����ǿ��ء����к�r<N��������Ϊr+N����������Ϊ(3N-2)-r��
      2���Ϸ���������ж�һ������(x, y)�Ƿ��ںϷ������ڣ�����x��x�ķ�ΧΪ[0, 2N-1)������y��y�ķ�ΧΪ[0, ����)�������ļ������1����
      3��6���ھ����ꡣ
              a.�����ھӡ�   (r,c-1)��(r,c+1)��
              b.�����ھӡ�   �к�r<Nʱ�������ھ�����(r-1,c-1)��(r-1,c)�����������ھ�����(r-1,c)��(r-1,c+1)��
              c.�����ھӡ�    �к�r<N-1ʱ�������ھ�����(r+1,c)��(r-1,c+1)�����������ھ�����(r+1,c-1)��(r+1,c)��
              ע�������ھ����궼��Ҫͨ��2���ĺϷ����������⡣
       4��N = 6ʱ�ĸ�������Ϊ1 + 6 + 12 + 18 + 24 + 30 = 91�� (ÿ�μ�һȦ��һȦ����Ϊ  6*(N-1))
Author: WhereIsHeroFrom
Update Time: 2018-3-29
Algorithm Complexity: O(N^2)
*/

struct HoneycombNode {
	int r, c;
	HoneycombNode() {}
	HoneycombNode(int _r, int _c) {
		r = _r;
		c = _c;
	}

	HoneycombNode left() {
		return HoneycombNode(r, c-1);
	}

	HoneycombNode right() {
		return HoneycombNode(r, c+1);
	}
};

// �䳲����ϵ
#define MAXH 6

class HoneycombAxis {
	int n;
	int id[2*MAXH][2*MAXH];
	int idCount;
	HoneycombNode nodes[4*MAXH*MAXH];

public:
	void init(int _n) {
		n = _n;
		int i, j;
		idCount = 0;
		for(i = 0; i < getRowCount(); ++i) {
			for(j = 0; j < getColCount(i); ++j) {
				id[i][j] = idCount;
				nodes[idCount] = HoneycombNode(i, j);
				++idCount;
			}
		}
	}

	// ��������
	int getRowCount() {
		return 2*n - 1;
	}

	// ��������
	int getColCount(int r) {
		if(r < n) {
			return n + r;
		}else {
			return 3*n - 2 - r;
		}
	}

	// ���ظ��Ӹ���
	int getIDCount() {
		return idCount;
	}

	// ���ظ����������
	int getNodeID(HoneycombNode& node) {
		return id[node.r][node.c];
	}

	// ͨ��ID���ظ���
	HoneycombNode getNode(int id) {
		return nodes[id];
	}

	// ���ص�ǰ���ӵı���Ƿ�Ϸ�
	bool isValid(HoneycombNode& node) {
		// ����
		if(node.r < 0 || node.r >= getRowCount()) {
			return false;
		}
		// ����
		if(node.c < 0 || node.c >= getColCount(node.r)) {
			return false;
		}
		return true;
	}

	void getNeighbors(HoneycombNode now, int &retSize, HoneycombNode *ret) {
		HoneycombNode tmp[6];
		int i;
		
		// �����ھ�
		tmp[0] = now.left();
		tmp[1] = now.right();
		
		// �����ھ�
		if(now.r < n) {
			tmp[2] = HoneycombNode(now.r-1, now.c-1);
		}else {
			tmp[2] = HoneycombNode(now.r-1, now.c);
		}
		tmp[3] = tmp[2].right();

		// �����ھ�
		if(now.r < n-1) {
			tmp[4] = HoneycombNode(now.r+1, now.c);
		}else {
			tmp[4] = HoneycombNode(now.r+1, now.c-1);
		}
		tmp[5] = tmp[4].right();


		retSize = 0;
		for(i = 0; i < 6; ++i) {
			if( isValid( tmp[i] ) ) {
				ret[retSize++] = tmp[i];
			}
		}
	}
};
