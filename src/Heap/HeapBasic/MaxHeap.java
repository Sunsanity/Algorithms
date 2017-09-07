package Heap.HeapBasic;

/**
 * Created by SJW on 2017/7/16.
 * 最大堆的基本实现
 */
public class MaxHeap<Item> {

    //堆数组
    private Item[] data;
    //堆数组长度
    private int count;

    /**
     * 构造方法
     * @param capacity
     */
    public MaxHeap(int capacity){
        this.count = 0;
        this.data = (Item[])new Object[capacity+1];
    }

    /**
     * 返回数组长度
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回堆数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 测试堆数组初始化
     * @param args
     */
    public static void main(String[] args){
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.isEmpty());
    }
}
