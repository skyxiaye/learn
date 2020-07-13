package com.BinaryTree;


interface IBinaryTree<E>{ // 定义二叉树操作接口
     void add(E data);
     void recursionAdd(E data); //递归调用
     void traversal();
     boolean search(E data);
     void delete(E data);
}
class BinaryTreeImpl<E> implements IBinaryTree{
    private class Node{
        private Comparable<E> data;
        private Node left;
        private Node right;
        private Node parent;
        public Node(Comparable<E> data){
            this.data = data;
        }
        public void add(Node node){
            if (this.data.compareTo((E) node.data)<=0){
                if (this.right == null){
                    this.right = node;
                }else {
                    this.right.add(node);
                }
            }else {
                if (this.left == null){
                    this.left = node;
                }else {
                    this.left.add(node);
                }
            }
        }
        // 中序遍历
        public void traversal(Node node){
            if (node != null) {
                node.traversal(node.left);
                System.out.println(node.data);
                node.traversal(node.right);
            }
        }
        public Node search(Node node){
            if (this.data.compareTo((E)node.data) == 0){
                return this;
            }
            if (this.data.compareTo((E)node.data) <= 0){
                if (this.right != null) {
                    return this.right.search(node);
                }
            }
            if (this.data.compareTo((E)node.data) >= 0){
                if (this.left != null) {
                    return this.left.search(node);
                }
            }
            return null;
        }
        // 查找已当前节点右节点为根结点的小节点
        public Node searchMin(Node node){
            if (node.left == null){
                return node;
            }else {
                return searchMin(node.left);
            }
        }
        public void delete(Node node){
            // 1、删除的节点是子节点
            // 2、删除的节点只有右节点或者左节点
            // 3、删除的节点既有左节点又有右节点

            if (node.left != null && node.right != null){
                Node minNode = searchMin(node.right);
                node.data = minNode.data;
                node = minNode;
            }
            Node child;
            if (node.left != null){
                child = node.left;
            }else {
                child = node.right;
            }
            if (node.parent.right == node){
                node.parent.right = child;
            }else {
                node.parent.left = child;
            }
        }
    }
    private Node root;
    // 二叉树实现结构
    @Override
    public void add(Object data) {
        Node newNode = new Node((Comparable)data);
        //保存根结点
        if (this.root == null){
            this.root = newNode;
        }else {
            Node currentNode = this.root;
            while (currentNode != newNode){
                if (currentNode.data.compareTo((E) newNode.data) <= 0){ //比根结点大
                    if (currentNode.right != null){
                        currentNode = currentNode.right;
                    }else {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        currentNode = newNode;
                    }
                }else {
                    if (currentNode.left != null){
                        currentNode = currentNode.left;
                    }else {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        currentNode = newNode;
                    }
                }
            }
        }
    }

    @Override
    public void recursionAdd(Object data) {
        Node newNode = new Node((Comparable)data);
        if (this.root == null){
            this.root = newNode;
        }else {
            this.root.add(newNode);
        }
    }

    @Override
    public void traversal() {
        if (this.root != null){
            this.root.traversal(this.root);
        }
    }

    @Override
    public boolean search(Object data) {
        return this.root.search(new Node((Comparable<E>) data)) == null? false:true;
    }

    @Override
    public void delete(Object data) {
        Node node = this.root.search(new Node((Comparable<E>)data));
        if (node != null){
            this.root.delete(node);
        }
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        IBinaryTree<Integer> binaryTree = new BinaryTreeImpl<Integer>();
        binaryTree.add(61);
        binaryTree.add(59);
        binaryTree.add(87);
        binaryTree.add(47);
        binaryTree.add(75);
        binaryTree.add(98);
        binaryTree.add(50);
        binaryTree.add(72);
        binaryTree.add(80);
        binaryTree.add(73);
        System.out.println("");

//        IBinaryTree<Integer> tree = new BinaryTreeImpl<Integer>();
//        tree.recursionAdd(61);
//        tree.recursionAdd(59);
//        tree.recursionAdd(87);
//        tree.recursionAdd(47);
//        tree.recursionAdd(73);
//        tree.recursionAdd(98);
//        System.out.println();
        binaryTree.delete(75);
        binaryTree.traversal();
//        System.out.println(binaryTree.search(59));
    }
}
