package UnionFind.OptimizeBySize;

/**
 * Created by hasee on 2017/7/30.
 * 并查集数据结构实现版本1(本质就是一个数组)
 * 并查集这种数据结构回答了节点于节点间是否存在连接关系的问题，但是却没有回答两者间的具体路径，所以是一种非常高效的判断两者是否存在连接关系的算法
 *
 * 主要的操作有union,select,isConnected,分别是并，查，是否连接方法
 */
public class UnionFind1 {

    private int[] id;
    private int count;

    public UnionFind1(int n){
        count = n;
        id = new int[n];
        for (int i=0;i<count;i++){
            id[i] = i;
        }
    }

    /**
     * 查找指定索引的元素
     * @param p
     * @return
     */
    private int find(int p){
        assert p>=0 && p<count;
        return id[p];
    }

    /**
     * 判断两个节点是否处于连接状态
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p,int q){
        return id[p] == id[q];
    }

    /**
     * 连接两个节点元素(这里的连接并不仅仅是两个元素的连接，指的是两类元素的所有节点的连接，所以需要遍历整个并查集将所有的一类元素转成另一个元素
     * ，使得两类元素的所有节点都处于连接状态)
     * @param p
     * @param q
     */
    public void unionElements(int p,int q){
        int pID = id[p];
        int qID = id[q];
        if (pID == qID){
            return;
        }
        for (int i=0;i<count;i++){
            if (id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
