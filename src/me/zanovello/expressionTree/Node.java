package me.zanovello.expressionTree;

public class Node {

    private eNodeType type;
    private float val;

    private Node left, right;

    public Node() {
    }

    public Node(eNodeType type, float val, Node left, Node right) {
        this.type = type;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(float val) {
        this.type = eNodeType.FLOAT;
        this.val = val;
    }

    public void evaluate() {
        if (type != eNodeType.FLOAT) {
            left.evaluate();
            right.evaluate();

            switch (type) {
                case SUM -> val = left.val + right.val;
                case SUB -> val = left.val - right.val;
                case MUL -> val = left.val * right.val;
                case DIV -> val = left.val / right.val;
                case MOD -> val = left.val % right.val;
            }
        }
    }

    @Override
    public String toString() {
        if(type != eNodeType.FLOAT)
            return type.toString();
        return Float.toString(val);
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public float getVal() {
        return val;
    }
}
