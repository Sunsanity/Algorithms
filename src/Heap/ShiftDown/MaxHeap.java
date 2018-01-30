package Heap.ShiftDown;

/**
 * Created by SJW on 2017/7/16.
 * 最大堆的基本实现
 */
public class MaxHeap<Item extends Comparable> {

    //堆数组
    protected Item[] data;
    //堆数组长度
    protected int count;
    //存储一份数组最大容量用于判断堆数组的是否发生了数组越界
    protected int capacity;

    /**
     * 构造方法
     * @param capacity
     */
    public MaxHeap(int capacity){
        this.count = 0;
        this.data = (Item[])new Comparable[capacity+1];
        this.capacity = capacity;
    }

    /**
     * 升级版构造方法(通过从最后一个非叶子节点的元素开始调用shiftDown方法调换元素位置，得到一个最大堆的数组实现，这种方式比一个一个插入堆数组的方式高效)
     */
    public MaxHeap(Item[] array){
        int length = array.length;
        //生成一个长度为length+1的数组，因为0号索引不用
        data = (Item[])new Comparable[length+1];
        capacity = length;
        //将新数组从1索引开始赋值
        for (int i=0;i<length;i++){
            data[i+1] = array[i];
        }
        count = length;
        //最后调用shiftDown方法将非最大堆数组调整成为一个最大堆数组
        for (int i=length/2;i>=1;i--){
            shiftDown(i);
        }
    }

    /**
     * 返回数组长度
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回堆数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 外界调用向堆数组中插入新元素方法
     * @param item
     */
    public void insert(Item item){
        assert count+1 <= capacity;

        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 取出堆中的最大元素
     * @return
     */
    public Item extractMax(){
        assert count > 0;
        //将堆顶元素[1]和堆底元素[count]交换位置,然后将新的堆顶元素放到正确的位置上，和子节点比较，如果比子节点都大的话不作操作，
        //如果比子节点小的话，和大的子节点交换位置，一直循环到正确位置break
        swap(1,count);
        count--;
        shiftDown(1);

        return data[1];
    }

    /**
     * 获取堆顶元素（即堆中的最大元素）
     * @return
     */
    public Item getMax(){
        assert count>0;
        return data[1];
    }

    /**
     * 向堆数组中插入新元素核心逻辑
     * @param k
     */
    private void shiftUp(int k){
        while (k>1 && data[k/2].compareTo(data[k]) < 0){
            swap(k,k/2);
            k = k/2;
        }
    }

    /**
     * 取出堆数组中的堆顶元素核心逻辑
     */
    private void shiftDown(int k){
        while (k*2 <= count){
            //将要交换的目标索引值
            int j = 2*k;
            //如果右节点比左节点还大的话，目标索引值赋值为右节点
            if (j+1 <= count && data[j+1].compareTo(data[j])>0){
                j++;
            }
            //如果父节点元素比子节点中最大的元素还要大的话停止循环，说明堆顶元素的位置已经放好
            if (data[k].compareTo(data[j]) > 0){
                break;
            }
            //交换父节点元素和目标元素的位置
            swap(k,j);
            k = j;
        }
    }

    /**
     * 测试堆数组的存值和取值方法
     * @param args
     */
    public static void main(String[] args){
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int n = 100;//堆中的元素个数
        int m = 100;//堆中的元素的取值范围(0-100)
        //向堆数组中添加元素
        for (int i=0;i<n;i++){
            maxHeap.insert(new Integer((int)(Math.random()*m)));
        }
        //新建一个数组，用于存放取出的堆顶元素
        Integer[] array = new Integer[n];
        //循环取出堆数组中的元素并打印（每次取出的都是堆顶的元素）
        for (int i=0;i<n;i++){
            array[i] = maxHeap.extractMax();
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //确保取出的数组顺序是逆序排列
        for (int i=1;i<n;i++){
            assert array[i-1] >= array[i];
        }
    }
}