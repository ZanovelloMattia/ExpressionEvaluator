package me.zanovello.parser;

import me.zanovello.expressionTree.Node;

import java.util.*;

public class Parser {

    String sExpression;
    int len;

    public Parser(String sExpression) {
        this.sExpression = sExpression;
        len = sExpression.length();
    }

    public void createTree(Node root) {
        root = getExpressionNode();
    }

    private Node getExpressionNode(String) {
        StringBuilder subExpres = new StringBuilder();
        List<Node> nodeList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int index = 0;

        if(sExpression == null){
            throw new RuntimeException("Expression in null");
        }

        if(!sExpression.isEmpty()){
            if(sExpression.charAt(0) == ')') throw new RuntimeException("Unexpected Token: ')' at index: " + index);
            if(sExpression.charAt(0) == '('){
                index++;
                while (index < sExpression.length() && sExpression.charAt(index) != ')'){
                    subExpres.append(sExpression.charAt(index));
                    index++;
                }
                if(index < sExpression.length() && sExpression.charAt(index) == '+'){
                    if(index = 0;)

                    nodeList.add(getAddingNode(subExpres.toString()));
                    opList.add('+');
                    subExpres.delete(0, subExpres.length());
                }

            }

        }

        while (index < len) {
            if (sExpression.charAt(index) == '+') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '+' at index: " + index);
                }

                nodeList.add(getAddingNode(subExpres.toString()));
                opList.add('+');
                subExpres.delete(0, subExpres.length());

            } else if (sExpression.charAt(index) == '-') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '-' at index: " + index);
                }

                nodeList.add(getAddingNode(subExpres.toString()));
                opList.add('-');
                subExpres.delete(0, subExpres.length());

            } else {
                subExpres.append(sExpression.charAt(index));
                index++;
            }
        }
    }

    private Node getAddingNode(String expr) {
        StringBuilder subExpres = new StringBuilder();
        List<Node> nodeList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int index = 0;

        while (index < expr.length()) {
            if (expr.charAt(index) == '*') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '*' at index: " + index);
                }

                nodeList.add(getFactorNode(subExpres.toString()));
                opList.add('*');
                subExpres.delete(0, subExpres.length());

            } else if (expr.charAt(index) == '/') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '/' at index: " + index);
                }

                nodeList.add(getFactorNode(subExpres.toString()));
                opList.add('/');
                subExpres.delete(0, subExpres.length());

            } else {
                subExpres.append(expr.charAt(index));
                index++;
            }
        }
    }

    private Node getFactorNode(String adding) {
        StringBuilder subExpres = new StringBuilder();
        List<Node> nodeList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int index = 0;

        if(!adding.isEmpty()){
            if(adding.charAt(0) == ')') throw new RuntimeException("Unexpected Token: ')' at index: " + index);
            if(adding.charAt(0) == '('){
                index++;
                while (index < adding.length()-1){
                    subExpres.append(adding.charAt(index));
                    index++;
                }

            }
        }

        while (index < adding.length()) {
            if (adding.charAt(index) == '(') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '+' at index: " + index);
                }

                nodeList.add(getAddingNode(subExpres.toString()));
                opList.add('*');
                subExpres.delete(0, subExpres.length());

            } else if (adding.charAt(index) == '-') {
                if(nodeList.isEmpty() && subExpres.isEmpty()){
                    throw new RuntimeException("Unexpected Token: '-' at index: " + index);
                }

                nodeList.add(getAddingNode(subExpres.toString()));
                opList.add('-');
                subExpres.delete(0, subExpres.length());

            } else {
                subExpres.append(adding.charAt(index));
                index++;
            }
        }
    }

    private Node getNumberNode() {
        StringBuilder sNum = new StringBuilder();

        while (Character.isDigit(sExpression.charAt(index))) {
            sNum.append(sExpression.charAt(index));
            index--;
        }

        sNum.reverse();

        return new Node(Float.parseFloat(sNum.toString()));
    }

}
