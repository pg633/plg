
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest/minutesToDie +1;
        for (int i = 0,max =1 ; ; i++,max *= n) {
            if(max >= buckets) return i;
        }
    }
}