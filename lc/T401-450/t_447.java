class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> m ;
        int res= 0;
        for (int i = 0; i < points.length; i++) {
            m = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i==j) continue;
                int pos = calc(points,i,j);
                m.put(pos,m.getOrDefault(pos,0)+1);
            }
            for (Integer k : m.keySet()) {
                Integer num = m.get(k);
                res += num *(num-1);
            }
        }
        return res;
    }

    private int calc(int[][] points, int i, int j) {
        return (points[i][0] -points[j][0])*(points[i][0] -points[j][0])+ (points[i][1] -points[j][1])*(points[i][1] -points[j][1]);
    }
}