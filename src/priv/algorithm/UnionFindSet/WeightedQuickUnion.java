package priv.algorithm.UnionFindSet;

public class WeightedQuickUnion extends UnionFindSet{
    // 维护每个连通分量大小
    private int[] setSize;

    public WeightedQuickUnion(int initSize) {
        super(initSize);
        this.setSize = new int[initSize];
    }

    @Override
    public void union(int nodeOne, int nodeTwo) {
        int nodeOneSetID = this.find(nodeOne);
        int nodeTwoSetID = this.find(nodeTwo);

        if (nodeOneSetID == nodeTwoSetID)
            return;
        // 将小连通分量连接到大的连通分量上，并修改连通分量大小，从而减小树高，提高 this.find()时间效率。
        if (this.setSize[nodeOneSetID] < this.setSize[nodeTwoSetID]) {
            this.ufset[nodeOneSetID] = nodeTwoSetID;
            this.setSize[nodeTwoSetID] += this.setSize[nodeOneSetID];
        } else {
            this.ufset[nodeTwoSetID] = nodeOneSetID;
            this.setSize[nodeOneSetID] += this.setSize[nodeTwoSetID];
        }
        this.count--;
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

    public int findV2(int node) {
        // 指向爷爷结点进行路径压缩，从而优化时间效率
        while (this.ufset[node] != node) {
            int parentNode = this.ufset[node];
            node = this.ufset[parentNode];
        }
        return node;
    }
}
