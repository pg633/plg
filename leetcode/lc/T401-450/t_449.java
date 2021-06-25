package leetcoder;


import java.util.Stack;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.left!=null||root.right!=null){
            sb.append('(');
            sb.append(serialize(root.left));
            sb.append(')');
            if(root.right!=null){
                sb.append('(');
                sb.append(serialize(root.right));
                sb.append(')');
            }
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Stack<Integer> s = new Stack<>();
        int l1 = -1;
        int l2 = -1;
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i)=='('){
                s.push(i);
            }else if(data.charAt(i)==')'){
                l2 = i;
                if(!s.isEmpty()){
                    l1  = s.pop();
                }
            }
            if(s.isEmpty() && l1!=-1)break;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(0,l1<0?data.length():l1) ));
        if(l1<l2) root.left = deserialize(data.substring(l1+1,l2));
        if(l2!=-1 && l2 <data.length()-2)root.right = deserialize(data.substring(l2+2,data.length()-1));
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

public class AAA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        String codec = new Codec().serialize(root);
        System.out.println(codec);
    }
}