package SortingBasic.InsertionSortAdvance;

import java.util.Arrays;

/**
 * Created by SJW on 2017/7/9.
 * 测试插入排序算法和选择排序算法的效率
 */
public class Main {

    public static void main(String[] args) {
        int n = 10000;

        /*Integer[] arr1 = SortTestHelper.generateTestArray(n,0,3);*/
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(n,100);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);

        //此时的选择排序比插入排序的效率高
        SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort",arr1);
        SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertSort",arr2);

        return;
    }
}
