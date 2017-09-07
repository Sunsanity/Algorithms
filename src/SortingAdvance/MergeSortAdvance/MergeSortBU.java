package SortingAdvance.MergeSortAdvance;

import java.util.Arrays;

/**
 * Created by SJW on 2017/7/11.
 * 归并排序自下而上算法(优化后)
 * 自下而上的归并排序算法：外层循环控制sz的大小，1》2》4》8
 * 外层循环是1的时候内层循环代表着排序两个元素，外层循环是2的时候内层循环代表着排序4个元素
 * 也解释了内层循环每次的偏移量是2sz
 */
public class MergeSortBU {

    private MergeSortBU(){}

    /**
     * 递归排序方法
     * @param array
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] array,int l,int mid,int r){
        //先复制数组到存储空间
        Comparable[] copy = Arrays.copyOfRange(array,l,r+1);

        //初始化
        int i = l;
        int j = mid + 1;

        for (int k=l;k<=r;k++){
            if (i > mid){   //说明左面的游标已经结束，左半边已经排序完成
                array[k] = copy[j-l];
                j++;
            }else if(j > r){    //说明右面的游标已经结束，右半边已经排序完成
                array[k] = copy[i-l];
                i++;
            }else if(copy[i-l].compareTo(copy[j-l])<0){ //说明左面比右边小
                array[k] = copy[i-l];
                i++;
            }else{  //说明左面比右边大
                array[k] = copy[j-l];
                j++;
            }
        }
    }

    /**
     * 优化后的递归排序数组
     * @param array
     */
    public static void sort(Comparable[] array){
        int length = array.length;
        //优化点2：如果数组的元素在15个以内的话，代表着数组的有序程度可能会比较强，所以这种情况下可以使用插入排序算法来代替归并排序法，效率会更高
        /*if (l>=r)
            return;*/
        for (int i = 0;i<length;i+=16){
            InsertSort.sort(array,0,Math.min(i+15,length-1));
        }
        for (int sz=16;sz<length;sz+=sz){
            //i+sz<length两个作用   第一个是表明了后一半边的数组是存在的，否则只有半边数组的话归并就失去意义了，第二个作用是使得i+sz-1大于了length
            //因此,i+sz-1没有数组越界
            //Math.min(i+sz+sz-1,length-1)的作用也是让i+sz+sz-1不会下标越界,一旦越界的话我们取length-1作为参数,这样就保证了不会发生数组下标越界的情况
            for (int i=0;i+sz<length;i+=sz+sz){
                if (array[i+sz-1].compareTo(array[i+sz]) > 0){
                    merge(array,i,i+sz-1,Math.min(i+sz+sz-1,length-1));
                }
            }
        }
    }


    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 50000;
        Integer[] arr = SortTestHelper.generateTestArray(N, 0, N);
        SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSort", arr);

        return;
    }
}
