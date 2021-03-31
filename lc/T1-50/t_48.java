class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0)return;
        //
        for(int i=0;i<matrix.length;i++)
            for(int j=i+1;j<matrix.length;j++){
                swap(matrix,i,j);
            }
        for(int i=0;i<matrix.length/2;i++){
            for(int j=0;j<matrix.length;j++){
                swap1(matrix,i,j);
            }
        }
    }
    private void swap(int [][]matrix ,int i,int j){
        int t=  matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }
    private void swap1(int [][]matrix ,int i,int j){
        int t=  matrix[j][i];
        matrix[j][i] = matrix[j][matrix.length-1-i];
        matrix[j][matrix.length-1-i] = t;
    }
}