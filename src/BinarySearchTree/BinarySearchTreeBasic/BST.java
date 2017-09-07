package BinarySearchTree.BinarySearchTreeBasic;

/**
 * Created by SJW on 2017/7/22.
 * 二分搜索树实现
 */
//key需要能够互相比较，所以需要实现Conparable类
public class BST<Key extends Comparable<Key>,Value> {

    /**
     * 私有内部类代表节点
     */
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        /**
         * 节点构造方法(初始化节点时左右子节点都应该是空的)
         * @param key 键
         * @param value 值
         * @param left 左节点
         * @param right 右节点
         */
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root; //二叉树应该有一个根节点，初始化时为空
    private int count; //所有节点的个数，初始化为0

    /**
     * 二叉树构造函数，初始根节点为空，树中所有子节点个数为0
     */
    public BST(){
        root = null;
        count = 0;
    }

    /**
     * 返回二叉树中的所有子节点的数量
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 测试方法
     * @param args
     */
    // TODO: 2017/7/22  
    public static void main(String[] args){
        
    }

}
