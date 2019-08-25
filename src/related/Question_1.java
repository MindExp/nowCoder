package related;

public class Question_1 {
    public static void main(String[] args) {
        String str = new String("ABCD");

        Question_1 question_1 = new Question_1();
        question_1.printAllSubString(str.toCharArray(), 0);
    }

    private char printAllSubString(char[] str, int index) {
        if (index == str.length)
            return ' ';

        System.out.println(str[index] + this.printAllSubString(str, index + 1));

        System.out.println(this.printAllSubString(str, index + 1));
        return ' ';
    }

    private void printAllSubString_Recursion(char[] str, int index) {

    }
}
