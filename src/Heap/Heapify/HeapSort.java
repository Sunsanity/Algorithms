package Heap.Heapify;

import Heap.ShiftDown.MaxHeap;

/**
 * 非复习类
 * Created by SJW on 2017/7/19.
 * 利用堆做排序
 * 这里我们不用新建一个数组用于存储新生成的最大堆
 * 而是直接让用户传过来一个数组我们将其构建成一个最大堆，然后原地排序，这种方法比之前的两种方法效率更高，因为不会额外的开辟空间用于最大堆的生成
 */
public class HeapSort {

    private HeapSort(){}

    /**
     * 利用堆排序算法的核心逻辑
     * @param array
     * @return
     */
    public static void sort(Comparable[] array){
        int n = array.length;
        //从数组的中间开始向前构造成一个最大堆数组
        for (int i=(n-1-1)/2;i>=0;i--){
            shiftDown2(array,n,i);
        }
        //将最大堆数组中的堆顶元素（最大元素）和数组中的最后一个元素互换位置，这样最后一个元素就是最大元素，就已经排序完毕
        //然后再将数组中的第一个元素进行shiftDown操作，将其放到正确的位置
        //然后重复循环直到1号索引位置结束，数组的顺序就已经排序完毕
        for (int i=n-1;i>0;i--){
            swap(array,i,0);
            shiftDown2(array,i,0);
        }
    }

    /**
     * 优化后shiftDown方法，采用赋值方式代替交换位置方式效率更高
     * @param arr
     * @param n
     * @param k
     */
    private static void shiftDown2(Comparable[] arr, int n, int k){
        Comparable e = arr[k];
        while (k*2+1<n){
            int j = 2*k+1;
            if (j+1<n && arr[j+1].compareTo(arr[j])>0){
                j = j+1;
            }
            if (e.compareTo(arr[j])>=0){
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    /**
     * 原始shiftDown方法
     * @param arr
     * @param n
     * @param k
     */
    private static void shiftDown(Comparable[] arr, int n, int k){
        while (k*2+1<n){
            int j = 2*k+1;
            if (j+1<n && arr[j+1].compareTo(arr[j])>0){
                j = j+1;
            }
            if (arr[k].compareTo(arr[j])>=0){
                break;
            }
            swap(arr,j,k);
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //测试堆排序算法
    public static void main(String[] args){
        int n = 100000;
        Integer[] array = SortTestHelper.generateTestArray(n,0,n);
        SortTestHelper.testSort("Heap.Heapify.HeapSort",array);
    }
}