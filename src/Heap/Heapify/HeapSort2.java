package Heap.Heapify;

import Heap.ShiftDown.MaxHeap;

/**
 * 复习类
 * Created by SJW on 2017/7/18.
 * 利用堆做排序(升级版生成堆得方式)
 * 此类调用MaxHeap中的传入一个数组的构造函数生成一个堆
 * 采用的思想是先将数组按照索引的顺序想象成一个堆，然后调整顺序，构造成一个真正的最大堆
 * 具体方法是：从最后一个非叶子节点的元素开始，调用shiftDown函数调整好该元素的位置，然后依次向前边遍历整个数组，将所有的元素都调整好自己的顺序，
 * 即构成了一个最大堆的数组
 *
 * 这种生成堆得方式比从头到尾一个一个追加堆元素的方式快的原因是可以直接从索引值/2的元素开始计算，省去了旧方法全部索引遍历的时间
 */
public class HeapSort2 {

    private HeapSort2(){}

    /**
     * 利用堆排序算法的核心逻辑
     * @param array
     * @return
     */
    public static void sort(Comparable[] array){
        //调用传入数组的构造方法通过更高效的方式生成一个堆数组
        Heap.ShiftDown.MaxHeap<Comparable> maxHeap = new Heap.ShiftDown.MaxHeap<>(array);
        int n = array.length;
        //依次取出堆数组中的堆顶元素从原数组的最后一个元素向前赋值，就得到了一个排序完成的数组
        for(int i=n-1;i>=0;i--){
            array[i] = maxHeap.extractMax();
        }
        /*for (int i=0;i<n;i++){
            System.out.println(array[i] + " ");
        }*/
    }

    //测试堆排序算法
    public static void main(String[] args){
        int n = 1000;
        Integer[] array = SortTestHelper.generateTestArray(n,0,1000);
        SortTestHelper.testSort("Heap.Heapify.HeapSort1",array);
    }
}