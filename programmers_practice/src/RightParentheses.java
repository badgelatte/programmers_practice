public class RightParentheses {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

    public static boolean solution(String s) {
        String[] parenthesesArr = s.split("");
        int parentheses = 0;

        for (int i = 0; i < parenthesesArr.length; i++) {
            if (parenthesesArr[i] == "(") {
                parentheses += 1;
            } else {
                parentheses -= 1;
            }

            if (parentheses < 0) {
                return false;
            }
        }

        if (parentheses != 0) {
            return false;
        }

        return true;
    }

    public static boolean solution2(String s) {
        String[] parenthesesArr = s.split("");
        boolean parentheses = false;

        for (int i = 0; i < parenthesesArr.length; i++) {
            if(!parentheses && parenthesesArr[i].equals(")")) {
                return false;
            }

            if (parentheses) {
                if (parenthesesArr[i].equals(")")) {
                    parentheses = false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
