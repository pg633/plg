
class Solution {
public:
    int times;
    int top;
    vector<int> dfn;
    vector<int> low;
    vector<int> stack;
    vector<bool> in_stack;
    void tarjan(const vector<vector<int> >& g, int i, set<vector<int> >& c) {
        dfn[i] = low[i] = ++times;
        stack[++top] = i;
        in_stack[i] = true;
        for (auto j : g[i]) {
            if (!dfn[j]) {
                tarjan(g, j, c);
                low[i] = min(low[i], low[j]);
            } else if (in_stack[j]) {
                low[i] = min(low[i], dfn[j]);
            }
            int prev = i;
            if (low[i] == dfn[i]) {
                while (top > 0 && low[stack[top]] == dfn[i]) {
                    c.insert({stack[top], prev});
                    prev = stack[top];
                    in_stack[stack[top]] = false;
                    --top;
                }
            }
        }
    }
    void reinit(int N) {
        times = 0;
        top = 0;
        dfn.clear();
        low.clear();
        stack.clear();
        in_stack.clear();
        dfn.resize(N + 1);
        low.resize(N + 1);
        stack.resize(N + 1);
        in_stack.resize(N + 1);
    }
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        int N = edges.size();
        reinit(N);
        vector<int> indegree(N + 1, 0);
        vector<vector<int> > g(N + 1);

        for (auto& e : edges) {
            ++indegree[e[1]];
            g[e[0]].push_back(e[1]);
        }
        // indegree 入  g  出
        set<vector<int> > c;
        for (int i = 1; i <= N; ++i) {
            if (!dfn[i]) tarjan(g, i, c);
        }
        
        int m = 0;
        int ind = 0;
        for (int i = 0; i < N; ++i) {
            int t = (indegree[edges[i][1]] > 1) + c.count(edges[i]);
            if (t >= m) {
                m = t;
                ind = i;
            }
        }
        return edges[ind];
    }
};
 