package UnionFind.QuickUnion;

/**
 * Created by hasee on 2017/7/30.
 * 并查集数据结构实现版本2(本质就是一个数组)
 * 并查集这种数据结构回答了节点于节点间是否存在连接关系的问题，但是却没有回答两者间的具体路径，所以是一种非常高效的判断两者是否存在连接关系的算法
 *
 * 主要的操作有union,select,isConnected,分别是并，查，是否连接方法
 *
 * 此版本的并查集实现相比版本一更新了union方法和find方法还有isConnected
 * 思路是使用Parent数组保存每一个节点的父亲节点，union操作时只需要将A节点的父亲节点设置为B节点就实现了union的连接操作
 * find操作时只需要查节点的根节点就得到了所在的联盟
 * isConnected操作时只需要判断两个节点的根节点的值是否相等就可以了
 */
public class UnionFind2 {

    private int[] parent;
    private int count;

    public UnionFind2(int n){
        count = n;
        parent = new int[n];
        for (int i=0;i<count;i++){
            parent[i] = i;
        }
    }

    /**
     * 查找指定元素所在的联盟
     * @param p
     * @return
     */
    private int find(int p){
        assert p>=0 && p<count;
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    /**
     * 判断两个节点是否处于连接状态
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * 连接两个节点元素(这里的连接并不仅仅是两个元素的连接，指的是两类元素的所有节点的连接，所以需要遍历整个并查集将所有的一类元素转成另一个元素
     * ，使得两类元素的所有节点都处于连接状态)
     * @param p
     * @param q
     * 更新后的逻辑：先找到了个元素的联盟号，相等的话代表一个联盟，退出循环，不等的话将A节点的根节点设置成B节点的根节点，这样两个元素就处于同一个联盟了
     */
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }
}
