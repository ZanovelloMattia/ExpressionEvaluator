package me.zanovello;

import me.zanovello.expressionTree.ExpressionTree;

public class Main {
    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.init();
        System.out.println("Il risultato è: " + expressionTree.eval());
    }
}