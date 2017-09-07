package SortingAdvance.QuickSort3Ways;

/**
 * Created by SJW on 2017/7/15.
 * 三路快速排序算法
 * 二路排序算法优点：可以有效的预防数组中有大量重复数据而导致普通快速排序算法的=V的元素始终放到了数组的一侧，这样会导致数组的切分变的越来越不均匀
 * 数组的切分一旦变的不均匀以后，数组的排序会变的效率低下
 * 二路排序算法将=v的元素平均分配到了数组的两侧，所以数组的切分会变的非常均匀，不会使得数组的切分变的差距很大，所以效率不会受到很大的影响
 *
 * 三路快速排序算法的优点：
 * 相比于二路排序算法，三路排序算法对于遍历元素=v的情况做了不同的处理，思路是将整个数组分成三组，左边是小于v，中间是等于v，右边是大于v
 * 优势在于对于等于v的元素可以不做处理，直接遍历下一个元素，而二路排序算法对于等于v的元素还要做一次交换，使得等于V的元素均匀的分布于数组的两侧
 * 所以对于相同元素非常多的数组而言，三路排序算法可以更快的处理排序，效率更高
 */
public class QuickSort3Ways {

    private QuickSort3Ways(){}


    /**
     * 三路快速排序算法核心逻辑
     * @param array
     * @param l
     * @param r
     */
    private static void sort(Comparable[] array,int l,int r){
        if (r-l<=15){
            InsertSort.sort(array,l,r);
            return;
        }
        //三路快速排序算法核心逻辑
        swap(array,l,(int)(Math.random()*(r-l+1))+l);
        Comparable v = array[l];
        //初始化索引值
        int lt = l;     //array[l+1...lt]<v
        int gt = r+1;   //array[gt...r]>v
        int i = l+1;    //array[lt+1...i)=v
        //遍历所有元素
        while (i<gt){
            if (array[i].compareTo(v)<0){
                swap(array,i,lt+1);
                lt++;
                i++;
            }else if (array[i].compareTo(v)>0){
                swap(array,i,gt-1);
                gt--;
            }else {
                i++;
            }
        }
        swap(array,l,lt);
        //分别递归左边小于v和右边大于v的两组数组再次执行三路快速排序算法
        sort(array,l,lt-1);
        sort(array,gt,r);
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
