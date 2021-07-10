package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;



class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)return null;
        return res(new HashMap<Integer,UndirectedGraphNode>(),node);
    }

    private UndirectedGraphNode res(HashMap<Integer, UndirectedGraphNode> m, UndirectedGraphNode node) {
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        m.put(node.label,copyNode);
        if(node.neighbors.size()==0){
            return copyNode;
        }
        node.neighbors.forEach(childNode->{
            copyNode.neighbors.add( m.get(childNode.label)==null?res(m,childNode):m.get(childNode.label));
        });
        return copyNode;
    }


}


public class Main {

    public static void main(String[] arg) {


    }

}