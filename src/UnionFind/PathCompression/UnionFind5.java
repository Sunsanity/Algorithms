package UnionFind.PathCompression;

/**
 * Created by hasee on 2017/7/30.
 * 并查集数据结构实现版本3(本质就是一个数组)
 * 并查集这种数据结构回答了节点于节点间是否存在连接关系的问题，但是却没有回答两者间的具体路径，所以是一种非常高效的判断两者是否存在连接关系的算法
 *
 * 主要的操作有union,select,isConnected,分别是并，查，是否连接方法
 *
 * 版本2优化点：
 *  此版本的并查集实现相比版本一更新了union方法和find方法还有isConnected
 * 思路是使用Parent数组保存每一个节点的父亲节点，union操作时只需要将A节点的父亲节点设置为B节点就实现了union的连接操作
 * find操作时只需要查节点的根节点就得到了所在的联盟
 * isConnected操作时只需要判断两个节点的根节点的值是否相等就可以了
 *
 * 版本3优化点：
 *  此版本的并查集相比版本二更新了union方法，让两个元素在union操作的时候执行一次判断，比较两个元素的根节点的联盟成员数量，
 *  然后指定数量少的联盟的父节点是数量多的父节点
 *  这样做避免了成员数量很多的联盟的最下面的成员想和别人union时候还需要不断向上查找父节点的降低效率的过程
 *
 * 版本4优化点：
 *  此版本的并查集相对于版本3的优化点在于取消使用size数组，我们决定将A挂在B上还是B挂了A上的条件应该是看谁的树的高度小，而不是看谁的元素少
 *  所以size判断根节点下面的树的高度的结果不准确，我们使用rank[]数组来存放以当前节点为父节点的树的高度
 *
 * 版本5优化点：
 *  此版本的并查集相比版本4优化点在于更新了find方法，不再一次一次的向上查找父节点，每查一个父节点时跳跃一次，这样就实现了路径压缩的概念
 *  这里能够跳跃查找而不出现错误的原因是并查集的特点之一（每个节点的父节点可能是自己，所以就算我们跳过了一个根节点也不会出现问题，因为这个根节点的父节点
 *  就是它自己）
 */
public class UnionFind5 {

    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind5(int n){
        count = n;
        rank = new int[n];
        parent = new int[n];
        for (int i=0;i<count;i++){
            parent[i] = i;
            rank[i] = 1;
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
            p = parent[parent[p]];
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
     * 更新后的版本2的逻辑：先找到了个元素的联盟号，相等的话代表一个联盟，退出循环，不等的话将A节点的根节点设置成B节点的根节点，这样两个元素就处于同一个联盟了
     * 更新后的版本3的逻辑：A和B互相结盟之前先做判断，将成员少的节点的父节点设置成成员多的父节点
     * 更新后的版本4的逻辑：AB做判断时判断的是两个树的高度，将矮的树的父节点设置成高的树的父节点
     */
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }
}