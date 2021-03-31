import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.isEmpty() ){
            return word2.length();
        }else if(word2.isEmpty()){
            return word1.length();
        }
        char [] src = word1.toCharArray();
        char [] des = word2.toCharArray();
        int [][] dp  = new int [src.length][des.length];
        for(int i=0;i<src.length;i++){
            Arrays.fill(dp[i],0);
        }

        for(int i=0;i<src.length;i++){
            if(des[0] == src[i]){
                dp[i][0] = i;
            }
            else{

                dp[i][0] = dp[i-1][0]+1;
            }
        }
        for(int j=0;j<des.length;j++) {
            if(src[0] == des[j]){
                dp[0][j] = j;
            }else{
                dp[0][j] = dp[0][j-1]+1;
            }
        }

//        for(int i=0;i<src.length;i++) {
//            for (int j = 0; j < des.length; j++) {
//                System.out.print(dp[i][j]+"    ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        for(int i=1;i<src.length;i++){
            for(int j=1;j<des.length;j++){
                if(src[i] == des[j]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
//        for(int i=0;i<src.length;i++) {
//            for (int j = 0; j < des.length; j++) {
//                System.out.print(dp[i][j]+"    ");
//            }
//            System.out.println();
//        }

        return dp[src.length-1][des.length-1];
    }

}