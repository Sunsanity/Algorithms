package SortingBasic.SelectionSortUsingComparable;

import java.util.Random;

/**
 * Created by SJW on 2017/7/8.
 * 排序
 * 选择排序法
 * 外层循环次数是参数数组长度，每次外层循环目的是确定每个位置的归属数字
 * 将每次外层循环位置定为最小元素
 * 然后内层循环从外层循环位置开始循环，长度为参数数组长度，每次循环目的是找到未确定位置元素中的最小值，然后与外层循环位置的元素互换位置，即
 * 确定当前外层循环位置的归属数字
 */
public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] array){
        int length = array.length;
        //外层每次循环确定每个位置的归属
        for(int i = 0;i < length;i++){
            int minIndex = i;
            for (int j = i+1;j < length;j++){
                if (array[j].compareTo(array[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    //调换两个元素位置方法
    private static void swap(Object[] array,int i,int minIndex){
        Object t = array[i];
        array[i] = array[minIndex];
        array[minIndex] = t;
    }

    public static void main(String[] args) {
        //测试Integer[]
        Integer[] array = {1,2,9,4,5,6,7,8,3};
        SelectionSort.sort(array);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print("  ");
        }

        //测试Double[]
        Double[] douArr = {2.2,1.1,4.4,3.3};
        SelectionSort.sort(douArr);
        for (int i=0;i<douArr.length;i++){
            System.out.print(douArr[i]);
            System.out.print("  ");
        }

        //测试String[]
        String[] strArr = {"D","B","C","A"};
        SelectionSort.sort(strArr);
        for (int i=0;i<strArr.length;i++){
            System.out.print(strArr[i]);
            System.out.print("  ");
        }
        
        //测试自定义数组
        Student[] stuArr = new Student[4];
        stuArr[3] = new Student("A",60);
        stuArr[0] = new Student("B",70);
        stuArr[1] = new Student("C",80);
        stuArr[2] = new Student("D",90);
        SelectionSort.sort(stuArr);
        for (int i=0;i<stuArr.length;i++){
            System.out.print(stuArr[i]);
            System.out.print("  ");
        }

    }
}
