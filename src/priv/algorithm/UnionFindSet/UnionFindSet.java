package priv.algorithm.UnionFindSet;

/**
 * 主要解决动态连通性问题，使用并查集数据结构实现动态连通性算法
 * 应用场景：1）网络布线问题，若两个结点已经连通则无需布线。2）变量等同性问题。
 * 建模：1）给定两个结点，判断连通性，若连通不需要给出连通路径
 * https://blog.csdn.net/dm_vincent/article/details/7655764
 */
public abstract class UnionFindSet {
    protected int[] ufset;
    protected int count;

    // 构造大小为 initSize 的并查集
    public UnionFindSet(int initSize) {
        this.count = initSize;
        ufset = new int[initSize];
        for (int index = 0; index < ufset.length; index++)
            ufset[index] = index;
    }

    // 连接 nodeOne 与 nodeTwo
    public abstract void union(int nodeOne, int nodeTwo);

    // 查找节点 node 所在的联通分量 ID
    public abstract int find(int node);

    public boolean connected(int nodeOne, int nodeTwo) {
        return find(nodeOne) == find(nodeTwo);
    }

    // 并查集中的连通分量个数
    public int count() {
        return this.count;
    }
}
