package Heap.ShiftUp;

/**
 * Created by SJW on 2017/7/16.
 * 最大堆的基本实现
 */
public class MaxHeap<Item extends Comparable> {

    //堆数组
    protected Item[] data;
    //堆数组长度
    protected int count;
    //存储一份数组最大容量用于判断堆数组的是否发生了数组越界
    protected int capacity;

    /**
     * 构造方法
     * @param capacity
     */
    public MaxHeap(int capacity){
        this.count = 0;
        this.data = (Item[])new Comparable[capacity+1];
        this.capacity = capacity;
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

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 外界调用向堆数组中插入新元素方法
     * @param item
     */
    public void insert(Item item){
        assert count+1 <= capacity;

        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 向堆数组中插入新元素核心逻辑
     * @param k
     */
    private void shiftUp(int k){
        while (k>1 && data[k/2].compareTo(data[k]) < 0){
            swap(k,k/2);
            k = k/2;
        }
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
