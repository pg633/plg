package leecoder;

class NumArray {
    int [] a ;
    int [] t;
    public NumArray(int[] nums) {
        if(nums == null ||nums.length ==0)return;
        a = new int[nums.length];
        t = new int[nums.length*4];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        build(0,0,nums.length-1);
    }

    private void build(int now, int l, int r) {
        if(l==r){
            t[now] = a[l];
            return;
        }
        int mid = l + (r-l)/2;
        int left = now *2 + 1;
        int right = now *2 + 2;
        build(left,l,mid);
        build(right,mid+1,r);
        t[now] = t[left] +t[right];
    }

    public void update(int i, int val) {
        if(i<0||i>=a.length) return ;
        up(0,0,a.length-1,i,val);
    }



    public int sumRange(int i, int j) {
        if(i<0 || j<0||i>=a.length || j>=a.length || i>j) return 0;
        return q(0,0,a.length-1,i,j);
    }

    private int q(int n, int l, int r, int ql, int qr) {
        if(l==ql && r==qr){
            return t[n];
        }
        int mid = l + (r-l)/2;
        int left = n *2 + 1;
        int right = n *2 + 2;
        if( mid +1 <= ql)
            return q(right,mid+1,r,ql,qr);
        else if(mid >= qr)
            return q(left,l,mid,ql,qr);
        else
            return q(left,l,mid,ql,mid) + q(right,mid+1,r,mid+1,qr);
    }
    private void up(int n, int l, int r, int id, int val) {
        if(l ==r){
            t[n] = val;
            return;
        }
        int mid = l + (r-l)/2;
        int left = n *2 + 1;
        int right = n *2 + 2;

        if(id>=mid+1){
            up(right,mid+1,r,id,val);
        }else{
            up(left,l,mid,id,val);
        }
        t[n] = t[left] + t[right];
    }
    public void pt() {
        for (int i : t) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}





public class Main {
    public static void main(String[] args) {
        System.out.println("aaaaaaaaaaaaaa");
        leecoder.NumArray numArray = new leecoder.NumArray(new int[]{9, -8});
        numArray.pt();
        System.out.println(numArray.sumRange(0,1));
        numArray.update(0, 3);
        numArray.pt();
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, -3);
        numArray.pt();
        System.out.println(numArray.sumRange(0, 1));

    }
}