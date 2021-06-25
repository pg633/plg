package leetcoder;





class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C <= E || H <= B || G <= A || D <= F)
            return (C-A)*(D-B)+(G-E)*(H-F);
        else
            return (C-A)*(D-B)+(G-E)*(H-F)-min(min(C-E, G-A), min(C-A, G-E))*min(min(H-B, D-F), min(D-B, H-F));
    }
    private int min(int a,int b){
        return a<b ?a:b;
    }
}
public class Main {

    public static void main(String[] arg) {


    }

}