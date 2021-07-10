class Solution {
    public String simplifyPath(String path) {

        String [] str = path.split("/");

        List<String> list = new ArrayList<>();
        Stack<String> st  = new Stack<>();
        for(String s :str){
            if(!s.equals("..") && !s.equals(".") && !s.equals("")){
                st.push(s);
            }else if (s.equals("..")){
                if(st.size()>0)
                    st.pop();
            }
        }
        return "/" +   String.join("/",st);
    }
}