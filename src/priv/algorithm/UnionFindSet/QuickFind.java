package priv.algorithm.UnionFindSet;

/**
 * 快速查，并查集算法
 * index 为结点编号，this.ufset[index] 为连通分量编号
 */
public class QuickFind  extends UnionFindSet{
    public QuickFind(int initSize) {
        super(initSize);
    }

    /**
     * 若共 N 个结点，连接对为 M，则时间复杂度为 O(M*N)
     * @param nodeOne
     * @param nodeTwo
     */
    @Override
    public void union(int nodeOne, int nodeTwo) {
        int nodeOneSetID = this.find(nodeOne);
        int nodeTwoSetID = this.find(nodeTwo);

        if (nodeOneSetID == nodeTwoSetID)
            return;
        // 修改连通分量
        for (int index = 0; index < this.ufset.length; index++) {
            if (this.ufset[index] == nodeTwoSetID)
                this.ufset[index] = nodeOneSetID;
        }
        // 连通分量数减 1
        this.count--;
    }

    /**
     * 快速查，返回结点 node 的连通分量 ID
     * @param node
     * @return
     */
    @Override
    public int find(int node) {
        return this.ufset[node];
    }
}
