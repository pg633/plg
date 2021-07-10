package leetcoder;

import DateStruct.Alg.max;
import sun.jvm.hotspot.tools.soql.SOQL;

import javax.print.attribute.standard.PrinterResolution;
import java.lang.reflect.Array;
import java.util.*;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    public String serialize(TreeNode root) {
        if(root ==null){
            return "null,";
        }
        return root.val + "," + serialize(root.left)+serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> q = new ArrayDeque<>(Arrays.asList(split));
        return func(q);


    }

    private TreeNode func(Queue<String> q) {
        String string = q.poll();
        if("null".equals(string)){
            return null;
        }
        TreeNode t = new TreeNode(Integer.valueOf(string));
        t.left = func(q);
        t.right = func(q);
        return t;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



public class Main {

    public static void main(String[] arg) {
        TreeNode  t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);

        String serialize = new leetcoder.Codec().serialize(t);
        System.out.println(serialize);


    }

}

