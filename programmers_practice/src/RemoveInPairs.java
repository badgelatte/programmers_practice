import java.util.Stack;

public class RemoveInPairs {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        Character c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
