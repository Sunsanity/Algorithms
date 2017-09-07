package SortingBasic.InsertionSortAdvance;

import java.lang.reflect.Method;

/**
 * Created by SJW on 2017/7/8.
 */
public class SortTestHelper {

    private SortTestHelper(){}

    //生成一个制定范围和个数的随机int数组
    public static Integer[] generateTestArray(int n,int rangeL,int rangeR){

        assert rangeL <= rangeR;
        Integer[] array = new Integer[n];

        for (int i = 0;i < n;i++){
            array[i] = new Integer((int)(Math.random()*(rangeR-rangeL+1)+rangeL));
        }
        return array;
    }

    /**
     * 打印给定的数组内容
     * @param objArray
     */
    public static void printArray(Object[] objArray){
        for (int i=0;i<objArray.length;i++){
            System.out.print(objArray[i]);
            System.out.print("  ");
        }
    }

    /**
     * 判断数组是否已经排序成功
     * @param array
     * @return
     */
    public static boolean isSorted(Comparable[] array){
        for (int i=0;i<array.length-1;i++){
            if (array[i].compareTo(array[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 测试算法的执行时间及是否排序成功
     */
    public static void testSort(String sortClassName,Comparable[] array){
        try {
            //通过反射获取类
            Class sortClass = Class.forName(sortClassName);
            //反射获取方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            //获取参数
            Object[] params = new Object[]{array};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted(array);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成一个近乎于有序的数组
     * @param n
     * @param swapTime  交互数组中的元素的次数，交换次数越少数组越有序，0为最有序
     * @return  返回一个接近有序的数组
     */
    public static Integer[] generateNearlyOrderedArray(int n,int swapTime){
        Integer[] array = new Integer[n];
        for (int i=0;i<n;i++){
            array[i] = new Integer(i);
        }
        for (int j=0;j<swapTime;j++){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            int t = array[a];
            array[a] = array[b];
            array[b] = t;
        }
        return array;
    }
}
