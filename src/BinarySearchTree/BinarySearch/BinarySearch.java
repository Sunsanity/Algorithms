package BinarySearchTree.BinarySearch;

/**
 * Created by SJW on 2017/7/22.
 * 二分查找法
 * 非递归实现
 */
public class BinarySearch {

    private BinarySearch(){}

    /**
     * 二分查找实现方法(非递归)
     * @param arr
     * @param target
     * @return
     */
    public static int find(Comparable[] arr,Comparable target){
        //在[l...r]中查找目标
        int l = 0;
        int r = arr.length-1;
        //l=r代表只有最后一个元素没有比较，执行最后一次循环
        while (l<=r){
            int mid = (r-l)/2+l;
            //区间中间元素等于目标元素，直接返回索引值
            if (arr[mid].compareTo(target)==0){
                return mid;
            }else if (arr[mid].compareTo(target)>0){ //区间中间元素大于目标元素将范围缩小，r=mid-1，否则相反逻辑即可
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }
}