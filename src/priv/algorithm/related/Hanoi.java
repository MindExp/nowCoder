package priv.algorithm.related;

public class Hanoi {
    public static void main(String[] args) {
        Hanoi.solution(3, "H1", "H2", "H3");
    }

    public static void solution(int n, String start, String middle, String end) {
        if (n == 1) {
            System.out.println("move " + start + " to " + end );
            return;
        }
        Hanoi.solution(n - 1, start, end, middle);
        Hanoi.solution(1, start, middle, end);
        Hanoi.solution(n - 1, middle, start, end);
    }
}
