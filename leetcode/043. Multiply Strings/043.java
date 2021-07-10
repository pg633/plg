package leetcoder;


class Solution1 {

    public String multiply(String num1, String num2) {
        if(num1==null || num1==null || num1.length() == 0 ||num2.length()==0) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.length() > num2.length()) return multiply(num2,num1);
        String ans ="";
        for(int i =0;i<num1.length();i++){
            int k = num1.charAt(num1.length()-i-1) -'0';
            ans = f(ans,k,i,num2);
        }
        return ans;
    }


    public String f(String ans ,int k,int n ,String m){
        String tmp = "";
        int Up=0;
        for(int i=0;i<m.length();i++){
            int  wei = m.length()-1-i;
            int d = (m.charAt(wei)-'0')*k+ Up;
            Up = d/10;
            d=d%10;
            tmp+=d;
        }
        while(Up!=0)
        {
            tmp+=Up%10;
            Up/=10;
        }
        for(int i=0;i<n;i++){
            tmp= "0"+tmp;
        }

        return add1(new StringBuffer(tmp).reverse().toString(),ans);
    }
    public String add1(String s1,String s2){
        if(s1 ==""||s1=="0"){
            return s2;
        }
        if(s2 ==""||s2=="0"){
            return s1;
        }
        int Up = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        String ans ="";
        int i=0;
        for(;i<Math.min(len1,len2);i++){
            int wei1 = s1.length()-1-i;
            int wei2 = s2.length()-1-i;

            int k1 = s1.charAt(wei1)-'0';
            int k2 = s2.charAt(wei2)-'0';
            int k3 = k1+k2+Up;
            Up = k3/10;
            k3%=10;
            ans +=k3;
        }
        while(i<len1){
            int wei1 = s1.length()-1-i;
            int k1 = s1.charAt(wei1)-'0';
            int k3 = k1+Up;
            Up = k3/10;
            k3%=10;
            ans +=k3;
            i++;
        }
        while(i<len2){
            int wei2 = s2.length()-1-i;

            int k2 = s2.charAt(wei2)-'0';
            int k3 = k2+Up;
            Up = k3/10;
            k3%=10;
            ans +=k3;
            i++;
        }
        while(Up!=0){
            int k3 = Up%10;
            Up/=10;
            ans+=k3;
        }
        return new StringBuffer(ans).reverse().toString();

    }
}



class Solution  {

    public String multiply(String num1, String num2) {
        char [] n1  = num1.toCharArray();
        char [] n2  = num2.toCharArray();
        int l1 = n1.length ;
        int l2 = n2.length;
        if(l1==0||l2 ==0)return"";
        int[] res = new int [l1+l2];
        for(int i=0;i<l1;i++){
            n1[i]-='0';
        }
        for(int i=0;i<l2;i++){
            n2[i]-='0';
        }
        for(int i=0;i<l1;i++){
            int Up = 0;
            for(int j=0;j<l2;j++){
                res[i+j] = res[i+j]+(n1[l1-1-i]*n2[l2-1-j])+Up;
                Up = res[i+j]/10;
                res[i+j]%=10;
            }
            int k =i+l2;
            while(Up!=0){
                res[k]+=Up;
                Up = res[k]/10;
                res[k]%=10;
                k++;
            }
        }
        StringBuffer sf = new StringBuffer(l1+l2);
        int i = l1+l2-1;
        while(i>0 && res[i]==0)i--;
        while(i>=0){
            sf.append(res[i--]);
        }
        return sf.toString();
    }
}