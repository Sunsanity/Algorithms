package BinarySearchTree.BinarySearch;

/**
 * Created by SJW on 2017/7/22.
 * 二分查找法
 * 递归实现二分查找法
 */
public class BinarySearch2 {

    private BinarySearch2(){}

    /**
     * 二分查找实现方法(递归方法)
     * @param arr
     * @param target
     * @return
     */
    public static int find(Comparable[] arr,Comparable target){
        return find(arr,0,arr.length-1,target);
    }

    /**
     * 二分查找法的递归实现
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    private static int find(Comparable[] arr,int l,int r,Comparable target){
        if (l>r){
            return -1;
        }
        //此处不使用int mid = (l+r)/2的原因是害怕发生索引越界的情况
        int mid = l+(r-l)/2;
        if (arr[mid].compareTo(target)==0){
            return mid;
        }else if (arr[mid].compareTo(target)>0){
            return find(arr,l,mid-1,target);
        }else {
            return find(arr,mid+1,r,target);
        }
    }
}