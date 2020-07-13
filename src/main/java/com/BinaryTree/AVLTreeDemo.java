package com.BinaryTree;

interface AVLTree<E>{
    void add(E data);
}

class AVLTreeImpl<E> implements AVLTree{

    private class Node{
        private Comparable<E> data;
        private Node left;
        private Node right;
        private int height =1;

        public Node(Comparable<E> data){
            this.data = data;
        }
        public int nodeHeight(Node node){
            if (node == null){
                return 0;
            }
            return node.height;
        }
        public Node add (Node tree,Node node) {
            if (tree.data.compareTo((E) node.data) <= 0) {
                if (tree.right == null) {
                    tree.right = node;
                } else {
                    tree.right = tree.right.add(tree.right,node);
                }
                if (nodeHeight(tree.right) - nodeHeight(tree.left) > 1){
                    if (tree.right.data.compareTo((E)node.data)<=0){
                        //RR
                        tree = RR(tree);
                    }else {
                        // RL
                        tree = RL(tree);
                    }
                }
            } else {
                if (tree.left == null) {
                    tree.left = node;
                } else {
                    tree.left = tree.left.add(tree.left,node);
                }
                if (nodeHeight(tree.left) - nodeHeight(tree.right) > 1) {
                    if (tree.left.data.compareTo((E)node.data)<=0){
                        //LR
                        tree = LR(tree);
                    }else {
                        // LL
                        tree = LL(tree);
                    }
                }
            }
            tree.height = (nodeHeight(this.left) > nodeHeight(this.right) ? nodeHeight(this.left) : nodeHeight(this.right)) + 1;
            return tree;
        }
        private Node LL(Node node){
            Node newNode;
            newNode = node.left;
            node.left = newNode.right;
            newNode.right = node;

            node.height = (nodeHeight(this.left) > nodeHeight(this.right) ? nodeHeight(this.left) : nodeHeight(this.right)) + 1;
            newNode.height = (nodeHeight(this.left) > node.height ? nodeHeight(this.left) : node.height) + 1;
            return newNode;
        }
        private Node RR(Node node){
            Node newNode;
            newNode = node.right;
            node.right = newNode.left;
            newNode.left = node;

            node.height = (nodeHeight(node.left) > nodeHeight(node.right) ? nodeHeight(node.left) : nodeHeight(node.right)) + 1;
            newNode.height = (nodeHeight(newNode.right) > node.height ? nodeHeight(newNode.right) : node.height) + 1;
            return newNode;
        }
        private Node LR(Node node){
            node.left = RR(node.left);
            return LL(node);
        }
        private Node RL(Node node){
            node.right = LL(node.right);
            return RR(node);
        }
    }
    private Node root;

    @Override
    public void add(Object data) {
        Node newNode = new Node((Comparable)data);
        if (this.root == null){
            this.root = newNode;
        }else {
            this.root=this.root.add(this.root,newNode);
        }
    }
}

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTreeImpl<Integer>();
//        tree.add(1);
//        tree.add(2);
//        tree.add(3);
//        tree.add(4);
//        tree.add(5);
//        tree.add(6);
//        tree.add(7);
//        System.out.println();
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        System.out.println();
    }
}
