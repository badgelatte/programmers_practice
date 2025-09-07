import java.util.Arrays;

public class sealedOrder {

    public static void main(String[] args) {
//        String[] strs = new String[]{"d","e","bb","aa","ae"};
//        String str = solution(30, strs);

        String[] strs = new String[] {"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"};
        String str = solution(7388, strs);
        System.out.println(str);
    }

    public static String solution(long n, String[] bans) {
        String answer = "";
        // a - z : 26
        // aa - az : 26 + ba - bz : 26 ... za - zz = 26 ^ 2
        // aaa - aaz : 26 + aba - abz : 26 + ... - azz = 26 ^ 2 +
        // -> baa - baz : 26 + bba - bbz : 26 ... - bzz = 26 ^ 2
        // -> aaa - zzz : 26 ^ 3

        long[] nums = new long[bans.length];

        // bans -> long로 변형
        for(int i = 0; i < bans.length; i++) {
            System.out.println(i+1 + ": " + bans[i]);
            nums[i] = strToLong(bans[i]);
        }
        Arrays.sort(nums);
        System.out.println();

        // 검수
        int nss = 0;
        for(int i = 0; i < nums.length; i++) {
            System.out.println("n: " + n + " > num["+i+"]: "+nums[i]);
            if(n > nums[i]) {
                n++;
            }
            System.out.println("n: " + n);
        }
        // jxk
//        n += nss;

        // n -> string으로 변경

        return longToStr(n);
    }

    public static long strToLong(String str) {
        char[] letters = str.toCharArray();
        long result = 0;

        System.out.print(str);
        for(int i = 0; i < letters.length; i++) {
            result += (letters[letters.length - 1 - i] - 96) * (long) (Math.pow(26, i));
            System.out.println(": " + result);
        }

        return result;
    }

    public static String longToStr(long num) {
        int length = 1;
        int count = 0;
        String str = "";

        System.out.println("num: " + num);

        // 총 길이 확인
        while((int)Math.pow(26, length++) > num) {
        }

        System.out.println("length: " + length);

        char[] letters = new char[length];

        // 바꾸기
        while (length-- > 0) {
            long a = num;
            count=0;
            for(int i = 0; i < length; i++) {
                a /= 26;
                count++;
            }
            System.out.println("a: " + a);

            letters[length] = (char)(a + 96);
            num -= a * (long) Math.pow(26,count);
            System.out.println("num: "+num);
        }

        System.out.print("[");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(" " + letters[i]);
        }
        System.out.println("]");

        for(int i = letters.length - 1; i >= 0; i--) {
            str += letters[i];
        }

        return str;
    }
}