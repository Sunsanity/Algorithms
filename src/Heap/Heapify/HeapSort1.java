package Heap.Heapify;

import Heap.ShiftDown.MaxHeap;

/**
 * Created by SJW on 2017/7/16.
 * 利用堆做排序
 */
public class HeapSort1 {

    private HeapSort1(){}

    /**
     * 利用堆排序算法的核心逻辑
     * @param array
     * @return
     */
    public static Comparable[] sort(Comparable[] array){
        int n = array.length;
        //新建一个空的堆数组
        MaxHeap<Comparable> heap = new MaxHeap<>(n);
        //向堆数组中添加元素
        for (int i=0;i<n;i++){
            heap.insert(array[i]);
        }

        //从堆数组中取出堆顶元素，然后从后往前重新放入到数组中，就得到一个顺序排列的数组
        for (int i=n-1;i>=0;i--){
            array[i] = heap.extractMax();
        }
        /*for (int i=0;i<n;i++){
            System.out.println(array[i] + " ");
        }*/
        return array;
    }

    //测试堆排序算法
    public static void main(String[] args){
        int n = 1000;
        Integer[] array = SortTestHelper.generateTestArray(n,0,1000);
        SortTestHelper.testSort("Heap.Heapify.HeapSort1",array);
    }
}