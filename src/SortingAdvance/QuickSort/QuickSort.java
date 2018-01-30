package SortingAdvance.QuickSort;

/**
 * Created by SJW on 2017/7/14.
 * 快速排序算法逻辑
 * 首先以一个元素为基准（第一个），外层每次循环的目的是找到一个基准元素的正确位置，然后做一次交换操作
 * 结果使得基准元素的左半边全部小于基准元素，右半边全部大于基准元素
 * 然后调用递归分别将左半边和右半边数组继续执行快速排序算法
 */
public class QuickSort {

    private QuickSort(){}

    /**
     * 快速排序核心逻辑
     * @param array
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] array,int l,int r){
        Comparable v = array[l];

        //array[l+1...j]<=v,array[j+1...i)>v
        int j = l;
        for (int i=l+1;i<=r;i++){
            if (array[i].compareTo(v) < 0){
                swap(array,i,++j);
            }
        }
        swap(array,l,j);
        return j;
    }

    /**
     * 递归调用快速排序算法
     * @param array
     * @param l
     * @param r
     */
    private static void sort(Comparable[] array,int l,int r){
        if (l>=r){
            return;
        }
        int j = partition(array,l,r);
        sort(array,l,j-1);
        sort(array,j+1,r);
    }

    /**
     * 外界调用公有快速排序算法
     * @param array
     */
    public static void sort(Comparable[] array){
        int n = array.length;
        sort(array,0,n-1);
    }

    /**
     * 调换数组内两个元素方法
     * @param array
     * @param i
     * @param j
     */
    private static void swap(Object[] array,int i,int j){
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
