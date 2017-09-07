package SortingAdvance.QuickSortNearlyOrdered;

/**
 * Created by SJW on 2017/7/14.
 * 快速排序算法（优化后）
 * 优化点一：数组长度<=16的时候调用插入排序算法排序
 * 优化点二：为防止快速排序对几乎有序的数组的排序速度很慢的情况，每次基准元素要随机选择一个，而不是从数组的最前面挨个遍历
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
        //在l-r中间随机找到一个元素，然后和l交换位置，但是被比较的目标元素仍然是第一个元素，既使得数组不会变的有序，而且之后的分组更加平均
        swap(array,l,(int)(Math.random()*(r-l+1)+l));
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
        if (r-l<=15){
            InsertSort.sort(array,l,r);
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
