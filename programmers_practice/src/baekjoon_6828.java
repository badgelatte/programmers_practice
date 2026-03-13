import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon_6828{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";

        while (sc.hasNextLine()) {
            str = sc.nextLine();
            if (Objects.equals(str, "0")) {
                break;
            }
            String[] strs = str.split(" ");
            String result = prefixToPostfix(strs);
            System.out.println(result);
        }
    }

    public static String prefixToPostfix (String[] strs) {
        Stack<String> stack = new Stack<>();
        String str = "";

        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("+")) {
                str += stack.pop() + " ";
                str += stack.pop() + " +";
                stack.push(str);
            } else if (strs[i].equals("-")) {
                str += stack.pop() + " ";
                str += stack.pop() + " -";
                stack.push(str);
            } else {
                stack.push(strs[i]);
            }

            str = "";
        }

        return stack.pop();
    }
}
