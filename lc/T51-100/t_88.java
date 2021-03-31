class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] a=new int [m];
        for(int i=0;i<m;i++)
            a[i] = nums1[i];
        int l =0 ;
        int r = 0;
        int i =0;
        while(l<m && r<n){
            if(a[l] < nums2[r])
                nums1[i++] = a[l++];
            else
                nums1[i++] = nums2[r++];
        }
        while(l<m ){
            nums1[i++] = a[l++];
        }
        while(r<n){
            nums1[i++] = nums2[r++];
        }

    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int i = len-1;
        int l =m-1;
        int r = n-1;

        while(l>=0 &&r>=0){
            if(nums1[l] > nums2[r])
                nums1[i--] = nums1[l--];
            else
                nums1[i--] = nums2[r--];
        }

        while(l>=0){
            nums1[i--] = nums1[l--];
        }
        while(r>=0){
            nums1[i--] = nums2[r--];
        }

    }
}