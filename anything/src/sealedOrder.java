import java.util.Arrays;

// programmers lv3 봉인된 주문
public class sealedOrder {

    public static void main(String[] args) {
        String[] strs = new String[]{"d","e","bb","aa","ae"};
        String str = solution(30, strs);

        String[] strs2 = new String[] {"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"};
        String str2 = solution(7388, strs);

        String[] strs3 = new String[] {"abc"};
        String str3 = solution(52, strs3);
        System.out.println(str3);
    }

    public static String solution(long n, String[] bans) {
        // a - z : 26
        // aa - az : 26 + ba - bz : 26 ... za - zz = 26 ^ 2
        // aaa - aaz : 26 + aba - abz : 26 + ... - azz = 26 ^ 2 +
        // -> baa - baz : 26 + bba - bbz : 26 ... - bzz = 26 ^ 2
        // -> aaa - zzz : 26 ^ 3

        long[] banNums = new long[bans.length];

        // bans -> long로 변형
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
        boolean flag = false;

        // str 총 길이 확인
        long num2 = num;

        while(0 < num2) {
            num2 /= 26;
            length++;
        }

        char[] letters = new char[length];

        // 숫자에서 글자(아스키코드)로 치환
        num2 = num;

        while(num2 > 0){
            if(num2 % 26 == 0) {
                flag = true;
            }
            num2 /= 26;
        }

        if(flag) {
            num -= 1;
        }

        // 숫자에서 글자(아스키코드)로 치환
        for (int i = length; i > 0; i--) {
            num2 = num;
            count = 0;

            for(int j = 0; j < i - 1; j++) {
                num2 /= 26;
                count++;
            }

            if(count == 0 && flag) {
                num2++;
            }

            letters[i - 1] = (char)(num2 + 96);
            num -= num2 * (long) Math.pow(26,count);
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");
    }
}