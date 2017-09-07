package SortingAdvance.MergeSort;

import SortingBasic.InsertionSort.SortTestHelper;

/**
 * Created by SJW on 2017/7/9.
 * 优化后的插入排序算法
 * 优化点在于之前的插入排序算法内层循环一直在不停的比较，同时也在不停的交换位置，交换位置需要三次赋值动作，会消耗时间
 * 优化后的算法采用赋值的方法，不再调用交换位置swap函数
 * 插入算法的最大特点是可以提前结束内层循环(一旦找到元素的合适位置)
 * 所以非常适用于对已经比较有序的数组进行排序，数组越有序，插入排序算法的排序速度就会越快，这一点优于选择排序算法
 */
public class InsertSort {
    private InsertSort(){}

    //插入排序逻辑
    public static void sort(Comparable[] array){
        int length = array.length;
        //外层每次循环目的是寻找第i个元素的合适插入位置
        for(int i = 1;i < length;i++){
            //先记住当前位置元素的值
            Comparable e = array[i];
            int j;
            for (j = i;j > 0 && array[j-1].compareTo(e) > 0;j--){
                array[j] = array[j-1];
            }
            //内层循环结束后j的值就是e需要放入的索引位置
            array[j] = e;
        }
    }

    //测试优化后的插入排序
    public static void main(String[] args) {
        //测试测试类生成随机数组和打印排序后结果方法
        int n = 10000;
        Integer[] array = SortTestHelper.generateTestArray(n,0,n);
        SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertSort",array);
    }
}
