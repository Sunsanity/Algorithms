package NewCode;

import java.util.Stack;

/**
 *
 * Created by hasee on 2018/1/31.
 */
public class Test {

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。START
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(Integer node){
        stack1.push(node);
    }

    public Integer pop(){
        Integer rel;
        if (stack2.empty()){
            while (!stack1.empty()){
                rel = stack1.peek();
                stack2.push(rel);
                stack1.pop();
            }
        }
        rel = stack2.peek();
        stack2.pop();
        return rel;
    }
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。END

    //操作给定的二叉树，将其变换为源二叉树的镜像。START
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public void Mirror(TreeNode root) {
            TreeNode tmp = null;
            if(root!=null){
                tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                if(root.left!=null){
                    Mirror(root.left);
                }
                if(root.right!=null){
                    Mirror(root.right);
                }
            }
        }
    }
    //操作给定的二叉树，将其变换为源二叉树的镜像。END


    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  START
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max((1+TreeDepth(root.left)),1+TreeDepth(root.right));
    }
    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  END

}
