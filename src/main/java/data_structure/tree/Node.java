package data_structure.tree;

/**
 * 二叉树树的每一个节点类
 */
public class Node<E extends Comparable<E>> {
    E e;    //节点内容
    Node left;    //左孩子
    Node right;    //右孩子

    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
    }
}
