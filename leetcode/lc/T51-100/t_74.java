class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length ==0 ) return false;
        if(matrix[0][0] > target) return false;
        int k = matrix.length-1;
        for(int i=0;i<matrix.length-1;i++){
            if(matrix[i][0] <=target && matrix[i+1][0] >target){
                k = i ;break;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if( matrix[k][i] == target) return true;
        }
        return false;
    }
}