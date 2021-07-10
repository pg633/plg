
class Solution {
    public int[] constructRectangle(int area) {
        int []res = new int[2];
        int sqrt = (int)Math.sqrt(area);
        for (int i = sqrt; i > 0; i--) {
            if(area % i ==0){
                res[1] = i;
                res[0] = area/i;
                return res;
            }
        }
        return res;
    }
}