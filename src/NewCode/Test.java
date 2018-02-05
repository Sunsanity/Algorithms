package NewCode;

import java.util.*;

/**
 *
 * Created by hasee on 2018/1/31.
 */
public class Test {

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。START
    /*private Stack<Integer> stack1 = new Stack<>();
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
    }*/
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。END

    //操作给定的二叉树，将其变换为源二叉树的镜像。START
    /*public class TreeNode {
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
    }*/
    //操作给定的二叉树，将其变换为源二叉树的镜像。END


    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  START
    /*public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max((1+TreeDepth(root.left)),1+TreeDepth(root.right));
    }*/
    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  END

    //输入一个链表，从尾到头打印链表每个节点的值。    START
    /*public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            this.printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }*/
    //输入一个链表，从尾到头打印链表每个节点的值。    END

    //请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。 START
    /*public String replaceSpace(StringBuffer str){
        if (str == null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }*/
    //请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。 END

    //现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39  START
    /*public int Fibonacci(int n){
        int a = 1;
        int b = 1;
        int c = 0;
        if (n < 0){
            return 0;
        }else if (n==1 || n==2){
            return 1;
        }else {
            for (int i=3;i<=n;i++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }*/
    //现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39  END

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。   START
    /*public double Power(double base, int exponent) {
        double temp = 1;
        if (exponent > 0){
            for (int i = 1;i<=exponent;i++){
                temp = temp * base;
                if (base > 1.7976931348623157E308){
                    System.out.println("超出double范围");
                    return -1;
                }
            }
            return temp;
        }else if (exponent < 0) {
            exponent = -exponent;
            for (int i = 1;i<=exponent;i++){
                temp = temp * base;
                if (base > 1.7976931348623157E308){
                    System.out.println("超出double范围");
                    return -1;
                }
            }
            return 1.0/temp;
        }else{
            return 1;
        }
    }*/

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    //所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。 START
    /*public void reOrderArray(int[] array){
        int length = array.length;
        for (int i=0;i<length-1;i++){
            for (int j=0;j<length-1-i;j++){
                if (array[j]%2==0 && array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }*/
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    //所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。 END


    //输入一个链表，输出该链表中倒数第k个结点。 START
    /*public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode node,int k){
        if (node == null){
            return null;
        }
        ListNode listNode = node;
        int count = 0;
        while (listNode != null){
            count++;
            listNode = listNode.next;
        }
        //判断是否访问索引超出范围
        if (k>count){
            return null;
        }
        ListNode p = node;
        for (int i=0;i<count-k;i++){
            p = p.next;
        }
        return p;
    }*/
    //输入一个链表，输出该链表中倒数第k个结点。 END

    //定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。   START
    /*Stack<Integer> stack = new Stack<Integer>();

    public void push(int a){
        stack.push(a);
    }
    public void pop(){
        stack.pop();
    }
    public int top(){
        return stack.peek();
    }

    public int min(){
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (tmp<min){
                min = tmp;
            }
        }
        return min;
    }*/
    //定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。   END

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    //由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。 START

    /*public int MoreThanHalfNum_Solution(int[] array){
        int length = array.length;
        if (length<1)
            return 0;
        int count = 0;
        Arrays.sort(array);
        int num = array[length/2];
        for (int i=0;i<length;i++){
            if (array[num] == array[i]){
                count++;
            }
        }
        if (count>length/2){
            return num;
        }
        return 0;
    }*/
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    //由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。 END


    //求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    //但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。  START
    /*public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i] == '1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }*/
    //求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    //但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。  END

    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    //例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。    START
    /*public String PrintMinNumber(int[] numbers){
        String result = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        for (int i:list){
            result += i;
        }
        return result;
    }*/
    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    //例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。    END

    //输入两个链表，找出它们的第一个公共结点。  START
    /*class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (pHead1 != null){
            map.put(pHead1,null);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            if (map.containsKey(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }*/
    //输入两个链表，找出它们的第一个公共结点。  END

    //在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置 START
    public int FirstNotRepeatingChar(String str){
        if (str == null || str.length()==0){
            return -1;
        }
        List<Character> list = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            char a = str.charAt(i);
            if (!list.contains(a)){
                list.add(Character.valueOf(a));
            }else {
                list.remove(Character.valueOf(a));
            }
        }
        if (list.size()<=0){
            return -1;
        }
        return str.indexOf(list.get(0));
    }

    //在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置 END
}
