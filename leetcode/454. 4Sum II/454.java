

class Solution {
    class node{
        int i;int j;

        public node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    class no{
        int n;
        node t;
        public no(int n, node t) {
            this.n = n;
            this.t = t;
        }
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Set<node>> m1 = new HashMap<>();
        Map<Integer,Set<node>> m2 = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int t = A[i]+B[j];
                if(m1.containsKey(t)){
                    m1.get(t).add(new node(i,j));
                }else{
                    m1.put(t,new HashSet<>());
                    m1.get(t).add(new node(i,j));
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int t = C[i]+D[j];
                if(m2.containsKey(t)){
                    m2.get(t).add(new node(i,j));
                }else{
                    m2.put(t,new HashSet<>());
                    m2.get(t).add(new node(i,j));
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Set<node>> is : m1.entrySet()) {
            if(m2.containsKey(-is.getKey())){
                res+=is.getValue().size()* m2.get(-is.getKey()).size();
            }
        }
        return res;
    }
}
