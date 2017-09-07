package GraghBasic.GraghRepresentation;

import java.util.Vector;

/**
 * Created by hasee on 2017/8/2.
 * 稀疏图的基本实现
 * 不要用于连接点比较少的图实现
 */
public class SparseGraph {

    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否有方向
    private Vector<Integer>[] g;//稀疏图存放的数据

    /**
     * 构造方法
     * @param n
     * @param directed
     */
    public SparseGraph(int n,boolean directed){
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        //初始化时vector中的vector的长度都为0
        g = (Vector<Integer>[]) new Vector[n];
        for (int i=0;i<n;i++){
            g[i] = new Vector<Integer>();
        }
    }

    public int V(){return n;}
    public int E(){return m;}

    /**
     * 向稀疏图中添加一条边,如果已经存在这条边的话就直接返回，不存在的话添加一条新边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        if (hasEdge(v,w)){
            return;
        }
        g[v].add(w);
        //如果两个点相等的话不允许添加自环边，如果是有序图的话也不允许反向再次添加边
        if (v!=w && !directed){
            g[w].add(v);
        }
        m++;
    }

    /**
     * 判断从v到w是否存在连接边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v,int w){
        assert v>=0 && v<n;
        assert w>=0 && w<n;

        for (int i=0;i<g[v].size();i++){
            if (g[v].elementAt(i) == w){
                return true;
            }
        }
        return false;
    }
}
