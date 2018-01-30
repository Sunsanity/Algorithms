package BinarySearchTree.BinarySearchTreeRemoveMinAndMax;

import java.util.LinkedList;

/**
 * 复习类
 * Created by SJW on 2017/7/26.
 * 二分搜索树实现
 * contain和search方法(搜寻节点)
 * 新增前中后遍历二叉树方法
 * 新增二叉树的广度遍历
 */
//key需要能够互相比较，所以需要实现Comparable类
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
         */
        public Node(Key key, Value value) {
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



    /***************************************/
    /**
     * 以上是内部属性和构造方法
     * 以下是用户可以调用的公开方法
     */
    /***************************************/



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
     * 添加节点公开方法
     * @param key
     * @param value
     */
    public void insert(Key key,Value value){
        root = insert(root,key,value);
    }

    /**
     * 公有的根据key查找树中的节点的value值
     * @param key
     * @return
     */
    public Value search(Key key){
        return search(root,key);
    }

    /**
     * 公有的查询树中书否存在key的节点
     * @param key
     * @return
     */
    public boolean contain(Key key){
        return contain(root,key);
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 后序遍历方法
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 二叉树的广度遍历
     * 之前的二叉树的前序，中序和后序遍历都是深度遍历，即从根节点首先一层一层的向深处寻找节点
     * 以下的遍历称为二叉树的广度遍历，也叫层序遍历，即一层一层的遍历二叉树的每一个节点
     * 首先遍历根节点，然后将根节点移除链表，然后遍历其子节点，有的话就加入到链表，然后继续循环移出链表并且打印节点
     */
    public void levelOrder(){
        //使用linkedlist作为栈使用
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        //循环结束的条件是链表内容为空，即结束了整个链表的遍历
        while (!list.isEmpty()){
            Node node = list.remove();
            System.out.println(node.key);
            if (node.left != null){
                list.add(node.left);
            }
            if (node.right != null){
                list.add(node.right);
            }
        }
    }

    /**
     * 寻找二叉树中的最小键值
     * @return
     */
    public Key minimum(){
        assert count != 0;
        Node node = minimum(root);
        return node.key;
    }

    /**
     * 寻找二叉树中的最大键值
     * @return
     */
    public Key maximum(){
        assert count != 0;
        Node node = maximum(root);
        return node.key;
    }

    /**
     * 移除掉二叉树中的最小值所在的节点
     */
    public void removeMin(){
        if (root != null){
            root = removeMin(root);
        }
    }

    /**
     * 移除掉二叉树中的最大值所在的节点
     */
    public void removeMax(){
        if (root != null){
            root = removeMax(root);
        }
    }

    /***************************************/
    /**
     * 以上是提供给用户的公开方法
     * 以下是程序内部的具体实现
     */
    /***************************************/


    /**
     * 向二叉树中添加子节点私有方法，用递归实现添加逻辑
     * @param node 想插入的目标节点
     * @param key 键
     * @param value 值
     * @return 新二叉树的根节点
     * 如果参数的node=null的话说明已经没有子节点可以比较，可以直接返回一个新建的node节点
     * 如果key比目标节点key小，往左下方放，否则右下方放，相等的话就替换目标节点的元素值
    */
    private Node insert(Node node,Key key,Value value){
        if (node == null){
            count ++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) == 0){
            node.value = value;
        }else if (key.compareTo(node.key) < 0){
            node.left = insert(node.left,key,value);
        }else {
            node.right = insert(node.right,key,value);
        }
        return node;
    }

    /**
     * 私有的根据key值查询树中是否存在元素
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node,Key key){
        //最终节点为空时代表整个树中没有找到对应key的元素
        if (node == null){
            return false;
        }
        //和节点的key比较，相等的话返回true
        if (key.compareTo(node.key) == 0){
            return true;
        }else if (key.compareTo(node.key) < 0){ //比节点的key小的话，找左子节点
            return contain(node.left,key);
        }else { //比节点的key大的话，找右子节点
            return contain(node.right,key);
        }
    }

    /**
     * 私有的根据key查找树中对应节点的value值
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node,Key key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) == 0){
            return node.value;
        }else if (key.compareTo(node.key) < 0){
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }

    /**
     * 私有的前序遍历树方法
     * @param node
     */
    private void preOrder(Node node){
        if (node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 私有的中序遍历树方法
     * @param node
     */
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 私有的后序遍历树方法
     */
    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 寻找二叉树中最小的键值节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二叉树中的最大键值节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二叉树中的最小节点
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        //如果左子节点为空的话。代表当前节点就是树中的最小值，直接返回右子节点就可以了，不管右子节点是否为空
       if (node.left == null){
           Node rightNode = node.right;
           node.right = null;
           count--;
           return rightNode;
       }
        //如果左子节点不为空的话，递归调用，参数为左子节点，返回值赋值给新二分树的根，但是整个返回结果应该是整个二叉树的根节点
       node.left = removeMin(node.left);
       return node;
    }

    /**
     * 递归删除二叉树中的最大值所在的节点
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 测试方法
     * @param args
     */
    // TODO: 2017/7/22  
    public static void main(String[] args){
        
    }
}