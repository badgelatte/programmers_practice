import java.util.*;

public class leecode_String {
    public static void main(String[] args) {
        String a = removeDuplicateLetters("dcadc");
        System.out.println(a);

        char[] chars = new char[]{'a','a','b','b','c','c'};
        int compress = compress2(chars);
        for (int i = 0; i < compress; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(isAnagram("anagram", "nagaram"));

        System.out.println(myAtoi("2147483648"));

        System.out.println(Reorder("3d, 1c, 5f, 7h, 2a, 4e, 6g"));

        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        String[] parentheses = s.split("");
        Stack<String> stack = new Stack();

        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i].equals("(") || parentheses[i].equals("{") || parentheses[i].equals("[")) {
                stack.push (parentheses[i]);
            }
            else {
                if (stack.isEmpty()) return false;

                String top = stack.pop();

                if(parentheses[i].equals(")") && !top.equals("(")){
                    return false;
                }
                if(parentheses[i].equals("}") && !top.equals("{")) {
                    return false;
                }
                if(parentheses[i].equals("]") && !top.equals("[")) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static String Reorder (String s) {
        String[] strs = s.split(", ");
        int min = 0;

        for(int i = 0; i< strs.length; i++){
            min = i;

            for(int j = i; j < strs.length; j++){
                if (strs[j].charAt(1) < strs[min].charAt(1)) {
                    min = j;
                }
            }
            String temp = strs[i];
            strs[i] = strs[min];
            strs[min] = temp;
        }

        s = "";
        for (int i = 0; i < strs.length; i++) {
            s += strs[i] + ", ";
        }

        return s.substring(0, s.length() - 2);
    }

    public static int myAtoi(String s) {
        int num = 0;
        boolean nowCount = false;
        boolean isMinus = false;
        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            // - 부호 확인
            if (!nowCount && s.charAt(i) == '-') {
                isMinus = true;
                nowCount = true;
            }
            // + 부호 확인
            else if (!nowCount && s.charAt(i) == '+') {
                isMinus = false;
                nowCount = true;
            }
            // 숫자인지 확인
            else if (Character.isDigit(s.charAt(i))) {
                nowCount = true;

                int digit = s.charAt(i) - 48;

                if (Integer.MAX_VALUE/ 10 < num || num == Integer.MAX_VALUE / 10 && digit > 7 ) {
                    if (isMinus) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }

                num = num * 10 + digit;
            }
            else {
                if (num > 0) {
                    if (isMinus) {
                        return num * -1;
                    }
                    return num;
                }
                return 0;
            }
        }

        if(isMinus) {
            num *= -1;
        }

//        if (Integer.MIN_VALUE/ 10 > num || num == Integer.MIN_VALUE / 10 && num % 10 > 8 ) {
//            return Integer.MIN_VALUE;
//        }
//
//        if (Integer.MAX_VALUE/ 10 < num || num == Integer.MAX_VALUE / 10 && num % 10 > 7 ) {
//            return Integer.MAX_VALUE;
//        }

        return num;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length()!= t.length()) {
            return false;
        }

        String[] strS = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if (!t.contains(strS[i])) {
                return false;
            }
            t = t.replaceFirst(strS[i],"");

        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        String reverseS = "";

        s = s.trim().toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            reverseS += s.charAt(s.length() - i - 1);
        }
        System.out.println(reverseS);
        return s.equals(reverseS);  // ==으로 하면 왜 뭊조건 false야?
    }

    public static String removeDuplicateLetters(String s) {
        String[] letters = s.split("");
        Set<String> strSet = new HashSet<>(List.of(letters));

        s = strSet.toString();
        return s.substring(1, s.length()- 1);
    }

    public static int compress2(char[] chars) {
        int count = 1;
        int startLetter = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                if (count == 1) {
                    chars[startLetter++] = chars[i];
                    continue;
                } else if (count > 99) {
                    chars[startLetter++] = chars[i];
                    chars[startLetter++] = (char) (count / 100 + '0');
                    chars[startLetter++] = (char) (count % 100 / 10 + '0');
                    chars[startLetter++] = (char) (count % 10 + '0');
                }
                else if (count > 9) {
                    chars[startLetter++] = chars[i];
                    chars[startLetter++] = (char) (count / 10 + '0');
                    chars[startLetter++] = (char) (count % 10 + '0');
                } else {
                    chars[startLetter++] = chars[i];
                    chars[startLetter++] = (char) (count + '0');
                }
                count = 1;
            } else {
                count++;
            }
        }

        if (count == 1) {
            chars[startLetter++] = chars[chars.length - 1];
            return startLetter;
        } else if (count > 99) {
            chars[startLetter++] = chars[chars.length - 1];
            chars[startLetter++] = (char) (count / 100 + '0');
            chars[startLetter++] = (char) (count % 100 / 10 + '0');
            chars[startLetter++] = (char) (count % 10 + '0');
        } else if (count > 9) {
            chars[startLetter++] = chars[chars.length - 1];
            chars[startLetter++] = (char) (count / 10 + '0');
            chars[startLetter++] = (char) (count % 10 + '0');
        } else {
            chars[startLetter++] = chars[chars.length - 1];
            chars[startLetter++] = (char) (count + '0');
        }

        return startLetter;
    }

    public static int compress(char[] chars) {
        int[] countLetter = new int[26];
        int asciiCode = 97;
        String groupname = "";

        for (char letter : chars) {
            countLetter[letter - 97]++;
        }

        for (int i = 0; i < countLetter.length; i++) {
            if (countLetter[i] == 0) {
                asciiCode++;
                continue;
            }
            else if(countLetter[i] == 1) {
                groupname += (char)asciiCode;
            }
            else {
                groupname += (char)asciiCode;
                groupname += countLetter[i];
            }
            asciiCode++;
        }

        return groupname.length();
    }
}
