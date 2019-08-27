package priv.algorithm.UnionFindSet;

/**
 * 快速并，并查集算法
 * 父节点表示法，index 为结点编号，this.ufset[index] 为父节点编号
 */
public class QuickUnion extends UnionFindSet{
    public QuickUnion(int initSize) {
        super(initSize);
    }

    @Override
    public void union(int nodeOne, int nodeTwo) {
        int nodeOneSetID = this.find(nodeOne);
        int nodeTwoSetID = this.find(nodeTwo);

        // 连接两个连通子集，连通分量(树)融合，若 nodeTwoSetID 所在连通分量相对较大时会构成“畸形树”；
        // 因此考虑连通分量大小后有“weighted quick union”算法(将小连通分量融合进大连通分量)。
        if (nodeOneSetID != nodeTwoSetID) {
            this.ufset[nodeTwoSetID] = nodeOneSetID;
            this.count--;
        }
    }

    /**
     * 获取联通分量 ID
     * @param node
     * @return
     */
    @Override
    public int find(int node) {
        while (this.ufset[node] != node)
            node = this.ufset[node];

        return node;
    }
}
