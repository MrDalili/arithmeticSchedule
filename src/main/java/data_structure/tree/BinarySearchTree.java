package data_structure.tree;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;//根节点
    private int size;//树中节点的个数

    /**
     * 无参构造函数
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

//    /**
//     * 有参构造函数，构造出有一个根节点的root
//     * @param root 根节点
//     */
//    public BinarySearchTree(Node<E> root) {
//        this.root = root;
//        size = 1;
//    }

    /**
     * 查找一个节点中最小的节点
     * 思路：（thinking analysis）
     *      查看是否有左子树，有左子树便一直往左找，无左子树返回根节点
     * @param node 要寻找除根节点以外的最小节点的根节点
     * @return 最小节点的Node值
     */
    public Node<E> findMinNode(Node<E> node){
        //先判断是否有左子树，有左子树那么最小值在左子树中
        if (node.left != null){
            //有左子树，那么将左子树的根节点当作node节点继续递归
            findMinNode(node.left);
        }
        //没有左子树，那么当前节点为最小值
        return node;
    }

    /**
     * 查找一个节点中最大的节点
     * 思路：（thinking analysis）
     *      看有没有右子树，有右子树一直向下找，无右子树便返回根节点
     * @param node 要寻找最大节点
     * @return 最大节点的Node值
     */
    public Node<E> findMaxNode(Node<E> node){
        //先判断是否有右子树,那么最大值在右子树中
        if (node.right != null){
            //有右子树，那么将右子树的根节点当作node继续递归
            findMaxNode(node.right);
        }
        //没有右子树，那么该节点为最大值
        return node;
    }


    public Node remove(Node<E> node,E e){
        Node<E> removeNode;
        //先判断根节点是否为空
        if (node == null){
            return null;
        }
        //判断e与node.e的大小
        if (e.compareTo(node.e) < 0){
            //如果根节点中的值大于e那么去左子树中找该节点
            remove(node.left,e);
        }else if (e.compareTo(node.e) >0){
            //如果根节点中的值小于e那么去右子树中找该节点
        }else {
            //如果e==node.e，那么证明找到该节点了
            //判断这个节点是否有左边
            if (node.left == null){
                if (node.right != null){
                    //无左节点有右节点，那么将右节点放上去
                }
            }
        }
        return null;
    }

    /**
     * 在根节点上添加一个元素
     * @param e 待添加的元素
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 递归在一个节点上添加一个元素
     * 思路：
     *      先查看要添加的根节点是否为空，如果为空，那么将待添加的元素放在这里
     *      不为空，则与该节点进行判断，小于则将左节点当作根节点进行递归，大于思路与左节点相同
     *      最后将e赋值给满足条件的节点
     * @param node  待添加新元素的根节点
     * @param e 带添加元素
     * @return 包含e的节点
     */
    private Node<E> add(Node<E> node,E e){
        //判断当前节点是否为空，为空那么就将node加在该节点
        if (node == null){
            size++;
            return new Node<E>(e);
        }
        //如果节点不为空，那么久要去比较大小，看往左边添加或者右边添加
        if (e.compareTo(node.e) < 0){
            //如果小于，那么查看他的左孩子，对他的左孩子进行判断
            node.left = add(node.left,e);
        }else if (e.compareTo(node.e) > 0){
            //如果大于，那么查看他的右孩子，将他的右孩子看作根节点进行添加
            node.right = add(node.left,e);
        }
        return node;
    }

}
