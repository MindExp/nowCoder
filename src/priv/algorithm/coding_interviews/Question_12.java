package priv.algorithm.coding_interviews;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 12. 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 * 测试用例：{{a, b, c, d}, {e, f, g, h}, {i, j, k, l}, {m, n, o, p}}, "fjko"
 */
public class Question_12 {
    public static void main(String[] args) {
        char[][] charMatrix = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}};
        LinkedList<String> testInstances= new LinkedList<>();
        Question_12 question_12 = new Question_12();

        testInstances.add("fjko");
        testInstances.add("dhgcbfe");
        testInstances.add("dhgcbfef");
        testInstances.add("fjhk");
        testInstances.add("");
        for (String path: testInstances)
            System.out.println(question_12.existPathInMatrixByRecursoin(charMatrix, path));
    }

    private boolean existPathInMatrixByRecursoin(char[][] charMatrix, String path) {
        boolean existPath = false;

        if (charMatrix == null)
            return false;
        if (path == "")
            return true;

        int rows = charMatrix.length, columns = charMatrix[0].length;

        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++){
                if (this.depthFirstSearch(charMatrix, path, row, column))
                    return true;
            }

        return existPath;
    }

    private boolean depthFirstSearch(char[][] charMatrix, String subPath, int row, int column) {
        boolean existPath;
        int rows = charMatrix.length, columns = charMatrix[0].length;

        if (subPath == "")
            return true;

        char currentChar = subPath.charAt(0);
        if (row < 0 || row > rows - 1 || column < 0 || column > columns - 1 || charMatrix[row][column] != currentChar)
            return false;

        if (subPath.length() == 1)
            subPath = "";
        else
            subPath = subPath.substring(1);

        char timeStampChar = charMatrix[row][column];
        charMatrix[row][column] = '\0';

        existPath = this.depthFirstSearch(charMatrix, subPath, row - 1, column) ||
                this.depthFirstSearch(charMatrix, subPath, row + 1, column) ||
                this.depthFirstSearch(charMatrix, subPath, row, column - 1) ||
                this.depthFirstSearch(charMatrix, subPath, row, column + 1);

        charMatrix[row][column] = timeStampChar;

        return existPath;
    }

    // 非递归方法任然存在部分问题，未通过所有测试用例，nowcoder
    private boolean existPathInMatrixByNonRecursion(char[][] charMatrix, String path) {
        boolean existPath = false;

        if (charMatrix == null || path.isEmpty())
            return existPath;

        char[] charPath = path.toCharArray();
        int step = 0, stepSize = charPath.length;
        Stack<StackNode> pathStack = new Stack();
        int rows = charMatrix.length, columns = charMatrix[0].length;
        int [][] visitedNodeInMatrix = new int[rows][columns];

        boolean foundFirst = false;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (charMatrix[row][column] == charPath[step]) {
                    visitedNodeInMatrix[row][column] = 1;
                    foundFirst = true;
                    // 将所有可选方向入栈
                    this.updatePathStack(pathStack, visitedNodeInMatrix, row, column, rows - 1, columns - 1);
                }
            }
        }

        if (foundFirst)
            step += 1;

        StackNode nextNode;
        int row, column;

        while (!pathStack.isEmpty()) {
            if (step == stepSize){
                existPath = true;
                break;
            }

            nextNode = pathStack.pop();
            row = nextNode.row;
            column = nextNode.column;

            if (charPath[step] == charMatrix[row][column]) {
                step += 1;
                visitedNodeInMatrix[row][column] = 1;
                this.updatePathStack(pathStack, visitedNodeInMatrix, row, column, rows - 1, columns - 1);
            } else if (charMatrix[row][column] == charPath[step - 1])
                visitedNodeInMatrix[row][column] = 0;
        }

        return existPath;
    }

    private void updatePathStack(Stack pathStack, int[][] visitedNodeInMatrix,
                                 int row, int column, int rows, int columns) {
        if (row == 0) {
            if (visitedNodeInMatrix[row + 1][column] != 1)
                pathStack.push(new StackNode(row + 1, column));

        }else if (row == rows) {
            if (visitedNodeInMatrix[row - 1][column] != 1)
                pathStack.push(new StackNode(row - 1, column));
        } else {
            if (visitedNodeInMatrix[row + 1][column] != 1)
                pathStack.push(new StackNode(row + 1, column));
            if (visitedNodeInMatrix[row - 1][column] != 1)
                pathStack.push(new StackNode(row - 1, column));
        }

        if (column == 0) {
            if (visitedNodeInMatrix[row][column + 1] != 1)
                pathStack.push(new StackNode(row, column + 1));
        }else if (column == columns) {
            if (visitedNodeInMatrix[row][column - 1] != 1)
                pathStack.push(new StackNode(row, column - 1));
        }else {
            if (visitedNodeInMatrix[row][column + 1] != 1)
                pathStack.push(new StackNode(row, column + 1));
            if (visitedNodeInMatrix[row][column - 1] != 1)
                pathStack.push(new StackNode(row, column - 1));
        }

    }

    class StackNode{
        int row;
        int column;

        public  StackNode(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
