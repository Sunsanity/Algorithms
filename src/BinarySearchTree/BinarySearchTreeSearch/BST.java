package BinarySearchTree.BinarySearchTreeSearch;

/**
 * Created by SJW on 2017/7/25.
 * 二分搜索树实现
 * contain和search方法(搜寻节点)
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
     * @return 新插入节点
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
     * 测试方法
     * @param args
     */
    // TODO: 2017/7/22  
    public static void main(String[] args){
        
    }
}