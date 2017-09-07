package SortingAdvance.QuickSort2Ways;

/**
 * Created by SJW on 2017/7/14.
 * 二路快速排序算法
 * 优点：可以有效的预防数组中有大量重复数据而导致普通快速排序算法的=V的元素始终放到了数组的一侧，这样会导致数组的切分变的越来越不均匀
 * 数组的切分一旦变的不均匀以后，数组的排序会变的效率低下
 * 二路排序算法将=v的元素平均分配到了数组的两侧，所以数组的切分会变的非常均匀，不会使得数组的切分变的差距很大，所以效率不会受到很大的影响
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
        //array[l+1...i)<=v,array(j...r]>=v
        int i = l+1;
        int j = r;
        while(true){
            while (i<=r && array[i].compareTo(v) < 0){
                i++;
            }
            while (j>=l+1 && array[j].compareTo(v) > 0){
                j--;
            }
            if (i>j){
                break;
            }
            swap(array,i,j);
            i++;
            j--;
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
