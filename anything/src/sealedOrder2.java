import java.util.Arrays;

// 앞글자부터 만들기 X / 뒷글자부터 만들기
public class sealedOrder2 {
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
        String str5 = solution(702, strs5);

        // azc
        String[] strs6 = new String[] {"aaaa"};
        String str6 = solution(1355, strs6);

        // bz
        String[] strs7 = new String[] {"aaa"};
        String str7 = solution(78, strs7);
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

    // l to string
    public static String longToStr(long num) {
        long num2 = num;
        int length = 0;

        while(0 < num2) {
            num2 /= 26;
            length++;
        }

        // 26 제곱근 다 더한 것과 num 비교하여 같을 경우 length - 1
        long sum = 0;
        int count = 0;

        while(sum < num) {
            sum += (long) (Math.pow(26, count++) * 26);
        }

        if(num == sum) {
            length--;
        }

        char[] letters = new char[length];

        for(int i = 0; i < length; i++) {
            num2 = num % 26;
            num /= 26;

            // 나머지가 0으로 나온다면 이는 26을 의미하며 z를 쓰도록 변환해주는 코드
            if(num2 == 0) {
                num2 = 26;
                num--;
            }

            letters[length - 1 - i] = (char) (num2 + 96);
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