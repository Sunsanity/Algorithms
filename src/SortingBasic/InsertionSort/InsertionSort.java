package SortingBasic.InsertionSort;

/**
 * Created by SJW on 2017/7/9.
 * 插入排序法
 * 逻辑与摆放扑克牌差不多
 * 外层循环从索引值为1的元素开始，向前一直到索引值为0的元素执行内层循环
 * 每次大循环的目的是确定当前元素的合适位置
 * 每次小循环的目的是比较当前元素和前一个元素的大小，如果小于前一个元素就交换位置，如果大于前一个元素说明当前元素位置正确，可以退出内层循环
 */
public class InsertionSort {

    private InsertionSort(){}

    //插入排序逻辑
    public static void sort(Comparable[] array){
        int length = array.length;
        //外层每次循环目的是寻找第i个元素的合适插入位置
        for(int i = 1;i < length;i++){
            for (int j = i;j > 0;j--){
                if (array[j].compareTo(array[j-1]) < 0){
                    swap(array,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    //调换两个元素位置方法
    private static void swap(Object[] array,int i,int minIndex){
        Object t = array[i];
        array[i] = array[minIndex];
        array[minIndex] = t;
    }

    //测试插入排序
    public static void main(String[] args) {
        //测试测试类生成随机数组和打印排序后结果方法
        int n = 10000;
        Integer[] array = SortTestHelper.generateTestArray(n,0,n);
        SortTestHelper.testSort("SortingBasic.InsertionSort.InsertionSort",array);
    }
}
