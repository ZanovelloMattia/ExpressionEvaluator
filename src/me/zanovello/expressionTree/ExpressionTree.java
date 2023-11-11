package me.zanovello.expressionTree;

public class ExpressionTree {

    Node root;

    public void init(){
        root = new Node(eNodeType.SUM, 0,
                new Node(eNodeType.MUL, 0, new Node(4), new Node(5)),
                new Node(eNodeType.DIV, 0, new Node(9), new Node(3)));
    }

    public float eval(){
        root.evaluate();
        return root.getVal();
    }

}
