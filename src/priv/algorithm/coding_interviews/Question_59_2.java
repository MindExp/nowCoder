package priv.algorithm.coding_interviews;

import java.util.LinkedList;

/**
 * 队列的最大值问题。
 * 定义一个队列并实现max得到队列的最大值，要求push、pop、max的时间复杂度均为O(1)。
 */
public class Question_59_2<T extends Comparable> {
    public static void main(String[] args) {
        QueueWithMax queueWithMax = new QueueWithMax();
        queueWithMax.push(2);
        System.out.println(queueWithMax.max());
        queueWithMax.push(3);
        System.out.println(queueWithMax.max());
        queueWithMax.push(-1);
        System.out.println(queueWithMax.max());
        queueWithMax.push(6);
        System.out.println(queueWithMax.max());
        queueWithMax.push(5);
        System.out.println(queueWithMax.max());
        queueWithMax.pop();
        System.out.println(queueWithMax.max());
        queueWithMax.pop();
        System.out.println(queueWithMax.max());
        queueWithMax.pop();
        System.out.println(queueWithMax.max());
        queueWithMax.pop();
        System.out.println(queueWithMax.max());
    }
}

class QueueWithMax {
    private int currentIndex = 0;
    private LinkedList<DataNode> dataList = new LinkedList<>();
    private LinkedList<DataNode> maxList = new LinkedList<>();

    public void push(int data) {
        DataNode dataNode = new DataNode(currentIndex, data);

        this.dataList.addLast(dataNode);
        this.currentIndex++;

        while (!maxList.isEmpty() && data >= maxList.getLast().getData())
            maxList.removeLast();

        this.maxList.addLast(dataNode);
    }

    public int pop() {
        DataNode maxDataNode = this.maxList.getFirst();
        DataNode popDataNode = this.dataList.getFirst();
        // 可简化为判断对象是否相同，省略定义 DataNode 类型
        if (popDataNode.getIndex() == maxDataNode.getIndex())
            this.maxList.removeFirst();

        return this.dataList.removeFirst().getData();
    }

    public int max() {
        return this.maxList.getFirst().getData();
    }
}

class DataNode {
    private int index;
    private int data;

    public DataNode(int index, int data) {
        this.index = index;
        this.data = data;
    }

    public int getIndex() {
        return this.index;
    }

    public int getData() {
        return this.data;
    }
}