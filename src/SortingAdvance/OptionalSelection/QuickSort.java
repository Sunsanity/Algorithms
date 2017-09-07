package SortingAdvance.OptionalSelection;

/**
 * Created by SJW on 2017/7/15.
 *
 * 引申问题：求数组中第N大的元素
 * 思路是利用快速排序算法(普通版快速排序算法，非二路和三路快速排序算法)解决问题
 *
 * 快速排序算法逻辑
 * 首先以一个元素为基准（第一个），外层每次循环的目的是找到一个基准元素的正确位置，然后做一次交换操作
 * 结果使得基准元素的左半边全部小于基准元素，右半边全部大于基准元素
 * 然后调用递归分别将左半边换右半边数组继续执行快速排序算法
 */
public class QuickSort {

    private QuickSort(){}

    /**
     * 快速排序核心逻辑
     * @param
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 求出nums[l...r]范围里第k小的数
    private static Comparable solve(Comparable[] nums, int l, int r, int k){

        if( l == r )
            return nums[l];

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums, l, r);

        if( k == p )    // 如果 k == p, 直接返回nums[p]
            return nums[p];
        else if( k < p )    // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
            return solve( nums, l, p-1, k);
        else // 如果 k > p, 则需要在nums[p+1...r]中找第k小元素
            return solve( nums, p+1, r, k );
    }

    // 寻找nums数组中第k小的元素
    public static Comparable solve(Comparable nums[], int n, int k) {

        assert k >= 0 && k < n;
        return solve(nums, 0, n - 1, k);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 Selection
    public static void main(String[] args) {

        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr = SortTestHelper.generateOrderedArray(N);
        SortTestHelper.shuffleArray(arr);

        // 验证selection算法, 对arr数组求第i小元素, 应该为i
        for( int i = 0 ; i < N ; i ++ ){
            assert solve(arr, N, i) == i;
            System.out.println("test " + i + " complete.");
        }

    }
}
