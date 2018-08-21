package com.info.tree.binarySearchTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by M on 2018/8/19.
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;


    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 想二分搜索竖树中添加新元素e
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    // 向以node为根节点的二分搜索树中插入元素 （递归算法）
    private Node add(Node node, E e) {
//        if (node.e.equals(e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为节点的二分搜索树中是否包含元素e (递归算法)
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 深度优先遍历
    // 二分搜索树的前序遍历   节点本身 --> 左孩子 --> 右孩子
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历 以node为根的二分搜索树 ，递归算法
    private void preOrder(Node node) {
//        if (node == null) {
//            return;
//        }

        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 二分搜索树的非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }


    // 二分搜索树的中序遍历 左孩子 --> 节点本身 --> 右孩子
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树 递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历   左孩子 --> 右孩子 --> 节点本身
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树 递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的层序遍历 （广度优先遍历）
    public void levelOrder() {
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public E getMin() {
        if (size == 0)
            throw new IllegalArgumentException("tree is empty");
        return getMin(root).e;
    }

    private Node getMin(Node node) {
        if (node.left == null)
            return node;
        return getMin(node.left);
    }

    public E getMax() {
        if (size == 0)
            throw new IllegalArgumentException("tree is empty");
        return getMax(root).e;
    }

    private Node getMax(Node node) {
        if (node.right == null)
            return node;
        return getMin(node.right);
    }

    // 从二分搜索树中删除最小值并返回
    public E removeMin() {
        E ret = getMin();
        root = removeMin(root);
        return ret;
    }

    // 删除以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值并返回
    public E removeMax() {
        E ret = getMin();
        root = removeMax(root);
        return ret;
    }

    // 删除以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除以node为根的二分搜索树中值为e的节点  递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除的节点左右子树均不为空
            // 找到比待删除节点大的最小节点，即待删除节点的右子树最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = getMin(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            binarySearchTree.add(num);

        binarySearchTree.preOrder();

//        System.out.println(binarySearchTree);
        System.out.println("=======================");
        binarySearchTree.inOrder();
//        System.out.println(binarySearchTree);
        System.out.println("=======================");
        binarySearchTree.postOrder();
        System.out.println("=======================");
        binarySearchTree.preOrderNR();
        System.out.println("=======================");
        binarySearchTree.levelOrder();
        System.out.println("=======================");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBinarySearchTreeString(root, 0, sb);
        return sb.toString();
    }

    private void generateBinarySearchTreeString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBinarySearchTreeString(node.left, depth + 1, sb);
        generateBinarySearchTreeString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
