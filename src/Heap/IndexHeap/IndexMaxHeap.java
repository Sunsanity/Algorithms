package Heap.IndexHeap;

/**
 * Created by SJW on 2017/7/19.
 * 索引最大堆的基本实现
 * 堆中存放的元素是真正数组中的索引值
 * 索引值再和真正的元素关联
 * 优点：不用额外增加一个保存索引值的属性，同时可以避免用户使用非数字数组来做比较，此种实现比较的只是数字，所以可以避免非数字的比较
 */
public class IndexMaxHeap<Item extends Comparable> {

    //堆数组
    protected Item[] data;
    //堆数组长度
    protected int count;
    //存储一份数组最大容量用于判断堆数组的是否发生了数组越界
    protected int capacity;
    //最大索引堆中的索引
    protected int[] indexes;
    //最大索引堆中的反向索引，指的是用户传入的索引位置+1在堆中的位置索引
    protected int[] reverse;

    /**
     * 构造方法
     * @param capacity
     */
    public IndexMaxHeap(int capacity){
        this.count = 0;
        this.data = (Item[])new Comparable[capacity+1];
        this.indexes = new int[capacity+1];
        this.capacity = capacity;
        this.reverse = new int[capacity+1];
        //初始化方法,因为初始化的indexed数组中没有元素，所以应该让反向索引数组中的元素都是0，代表目前indexes中的元素没有被保存位置信息
        for (int i=0;i<=capacity;i++){
            reverse[i] = 0;
        }
    }

    /**
     * 升级版构造方法(通过从最后一个非叶子节点的元素开始调用shiftDown方法调换元素位置，得到一个最大堆的数组实现，这种方式比一个一个插入堆数组的方式高效)
     */
    public IndexMaxHeap(Item array[]){
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
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    /**
     * 外界调用向堆数组中插入新元素方法
     * @param item
     */
    public void insert(int i,Item item){
        assert count+1 <= capacity;
        assert i+1>count && i+1<capacity;

        //需要保证在插入一个元素之前这个元素在堆数组中不存在位置信息,说明用户想插入元素的位置没有元素,这样才允许用户插入新元素
        assert !contain(i);

        i = i+1;

        data[i] = item;
        reverse[i] = count+1;
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
        Item ret = data[indexes[1]];
        swap(1,count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 取出堆中的最大元素索引
     * @return
     */
    public int extractMaxIndex(){
        assert count > 0;
        //将堆顶元素[1]和堆底元素[count]交换位置,然后将新的堆顶元素放到正确的位置上，和子节点比较，如果比子节点都大的话不作操作，
        //如果比子节点小的话，和大的子节点交换位置，一直循环到正确位置break
        int ret = indexes[1]-1;
        swap(1,count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 获取堆顶元素（即堆中的最大元素）
     * @return
     */
    public Item getMax(){
        assert count>0;
        return data[indexes[1]];
    }

    /**
     * 获取最大堆堆顶元素的索引值，对于外界用户来说索引要做-1处理，因为用户一方认为索引是从0开始计算的
     * @return
     */
    public int getMaxIndex(){
        assert count>0;
        return indexes[1]-1;
    }

    /**
     * 获取指定索引值位置的元素
     * @param i
     * @return
     */
    public Item getItem(int i){
        assert i+1>=1 && i+1<=capacity;
        //确保用户想取出的元素必须存在
        assert contain(i);
        return data[i+1];
    }

    /**
     * 向堆数组中插入新元素核心逻辑
     * @param k
     */
    private void shiftUp(int k){
        while (k>1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0){
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
            //如果右节点比左节点还打的话，目标索引值赋值为右节点
            if (j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]])>0){
                j++;
            }
            //如果父节点元素比子节点中最大的元素还要大的话停止循环，说明堆顶元素的位置已经放好
            if (data[indexes[k]].compareTo(data[indexes[j]]) > 0){
                break;
            }
            //交换父节点元素和目标元素的位置
            swap(k,j);
            k = j;
        }
    }

    /**
     * 将数组中指定索引位置的元素换成给定的元素
     * @param i
     * @param item
     */
    public void chanege(int i,Item item){
        //保证用户想替换的索引位置在堆数组中存在位置信息
        contain(i);
        i+=1;
        //赋值新元素
        data[i] = item;
        //找到元素对应堆中的位置,然后shiftdown和shiftup调整indexes[]中元素的位置
        /*for (int j=1;j<=count;j++){
            if (indexes[j] == i){
                shiftDown(j);
                shiftUp(j);
                return;
            }
        }*/
        //不用再用上面的循环来查找元素在对应堆中的位置,直接使用我们自己新维护的反向索引数组来通过[]索引位置直接查找位置，效率更高
        //reverse[i]代表用户想要替换的索引位置在堆中的索引位置
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    /**
     * 判断用户传进来的索引值在堆数组中是否存在对应的位置信息
     * @param i
     * @return
     */
    public boolean contain(int i){
        assert i+1>=1 && i+1<=capacity;
        return reverse[i+1] != 0;
    }

    /**
     * 测试堆数组的存值和取值方法
     * @param args
     */
    /*public static void main(String[] args){
        IndexMaxHeap<Integer> maxHeap = new IndexMaxHeap<>(100);
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
    }*/
}