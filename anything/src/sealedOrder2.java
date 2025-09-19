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
        String str4 = solution(702, strs4);

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
        long n = 0;


//        print(num);

//        return addChar(num);
        return num +"";
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