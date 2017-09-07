package GraghBasic.GraghRepresentation;

/**
 * Created by SJW on 2017/8/1.
 * 稠密图的基础实现
 * 稠密图一般用于实现比较复杂的图，即每个节点基本都是和所有其他的节点都是相连的
 */
public class DenseGraph {

    //节点数
    private int n;
    //边数
    private int m;
    //是否为有向图
    private boolean directed;
    //二维数组，表示节点间是否相连
    private boolean[][] g;

    //构造函数
    public DenseGraph(int n,boolean directed){
        this.n = n;
        //初始边数为零
        this.m = 0;
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    //返回节点个数
    public int V(){
        return n;
    }

    //返回边个数
    public int E(){
        return m;
    }

    /**
     * 从N到M新增一条边
     * @param v
     * @param m
     */
    public void addEdge(int v,int m){
        assert v >= 0 && v < n;
        assert m >= 0 && m < n;
        //如果已经存在这条边的话直接返回
        if (hasEdge(v,m)){
            return;
        }
        g[v][m] = true;
        //如果是无向图的话反向也要置为true
        if (!directed){
            g[m][v] = true;
        }
        m++;
    }

    //判断从V到M是否有边
    public boolean hasEdge(int v,int m){
        assert v >= 0 && v < n;
        assert m >= 0 && m < n;

        return g[v][m];
    }
}
