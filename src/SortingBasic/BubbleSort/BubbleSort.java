package SortingBasic.BubbleSort;

/**
 * Created by SJW on 2017/7/10.
 * 冒泡排序算法
 * 外层循环每次将未排序的数组中的最大值放到未排序数组的最末尾位置
 * 内层循环第一次循环length-1次(两两比较元素大小),因为每次外层循环会调整好一个元素的位置，所以每一次外层循环结束后执行内层
 * 循环时循环的次数要少一次（即两两比较的次数可以少一次，因为每次都可以少考虑一个元素的位置）
 */
public class BubbleSort {

    private BubbleSort(){}

    //冒泡排序逻辑
    public static void sort(Comparable[] array){
        int length = array.length;
        //外层每次循环目的是将数组中没有排序的最大元素放到数组的最末尾位置
        boolean flag;
        do{
            flag = false;
            for (int i=1;i<length;i++){
                if (array[i-1].compareTo(array[i]) > 0){
                        swap(array,i,i-1);
                    flag = true;
                }
            }
            length--;
        }while(flag);
    }

    //调换两个元素位置方法
    private static void swap(Object[] array,int i,int minIndex){
        Object t = array[i];
        array[i] = array[minIndex];
        array[minIndex] = t;
    }
}
