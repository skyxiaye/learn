package com.BinaryTree;

interface BinaryTree<E>{
    public void add(E data);
}

class Node<E> implements BinaryTree {
        private Comparable<E> data;
        private Node left;
        private Node right;
        private Node root;

        public Node(Comparable<E> data) {
            this.data = data;
        }

    public Node() {

    }

    @Override
        public void add(Object data) {
            if (data == null){
                return;
            }
            Node newNode = new Node((Comparable)data);
            if (this.root == null){
                this.root = newNode;
            }else {
                Node currentNode = this.root;
                if (currentNode.data.compareTo((E) newNode.data) <= 0) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                    } else {
                        currentNode.left.add(data);
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                    } else {
                        currentNode.right = newNode;
                    }
                }
            }
        }
    }

public class SimpleTreeDemo {
    public static void main(String[] args) {
        Node<Integer> tree = new Node<>();
        tree.add(61);
        tree.add(59);
        tree.add(87);
        tree.add(47);
        tree.add(73);
        tree.add(98);
        System.out.println();
    }
}
