import java.util.Arrays;

// programmers lv3 봉인된 주문
public class sealedOrder {

    public static void main(String[] args) {
        // ah
        String[] strs = new String[]{"d","e","bb","aa","ae"};
        String str = solution(30, strs);

         // jxk
        String[] strs2 = new String[] {"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"};
        String str2 = solution(7388, strs2);

        // z
        String[] strs3 = new String[] {"abc"};
        String str3 = solution(26, strs3);

        // az
        String[] strs4 = new String[] {"aaa"};
        String str4 = solution(52, strs4);

        // zz
        String[] strs5 = new String[] {"aaa"};
        String str5 = solution(702, strs4);
    }

    public static String solution(long n, String[] bans) {
        // a - z : 26
        // aa - az : 26 + ba - bz : 26 ... za - zz = 26 ^ 2
        // aaa - aaz : 26 + aba - abz : 26 + ... - azz = 26 ^ 2 +
        // -> baa - baz : 26 + bba - bbz : 26 ... - bzz = 26 ^ 2
        // -> aaa - zzz : 26 ^ 3

        long[] banNums = new long[bans.length];

        // bans; string -> long로 변형
        for (int i = 0; i < bans.length; i++) {
            banNums[i] = strToLong(bans[i]);
        }

        Arrays.sort(banNums);

        // 주문 지우기
        for (long num : banNums) {
            if (n >= num) {
                n++;
            }
        }

        // n -> string으로 변경
        return longToStr(n);
    }

    public static long strToLong(String str) {
        char[] letters = str.toCharArray();
        long result = 0;

        for(int i = 0; i < letters.length; i++) {
            result += (letters[letters.length - 1 - i] - 96) * (long) (Math.pow(26, i));
        }

        return result;
    }

    public static String longToStr(long num) {
        int length = 0;
        int count = 0;

        // str 총 길이 확인
        long num2 = num;

        while(0 < num2) {
            num2 /= 26;
            length++;
        }

        char[] letters = new char[length];

        // 숫자에서 글자(아스키코드)로 치환
        for (int i = letters.length; i > 0; i--) {
            num2 = num;
            count = 0;
            length--;

            while(length > count) {
                num2 /= 26;
                count++;
            }

            letters[i - 1] = (char) (num2 + 96);
            num -= num2 * (long) Math.pow(26, count);
        }

        // z 글자로 인한 오류 정정 구간
        for(int i = 0; i < letters.length - 1; i++) {
            if(letters[i] - 'a' < 0) {
                letters[i + 1] = (char) (letters[i + 1] - 'a' + 96);
                letters[i] = 'z';
            }
        }

        if(letters[letters.length - 1] - 'a' < 0) {
            letters = Arrays.copyOf(letters, letters.length - 1);
        }

        print(letters);

        return addChar(letters);
    }

    public static String addChar(char[] arr) {
        String str = "";

        for(int i = arr.length - 1; i >= 0; i--) {
            str += arr[i];
        }

        return str;
    }

    public static void print(char[] arr) {
        System.out.print("[");

        for (char c : arr) {
            System.out.print(" " + c);
        }

        System.out.println("]");
    }
}