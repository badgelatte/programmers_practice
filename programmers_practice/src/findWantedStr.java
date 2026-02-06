public class findWantedStr {
    public static void main(String[] args) {
        System.out.println(solution("aaaa", "aaaaa"));

        String a = "aaaa";
        a= a.toLowerCase();
        String b = "aaaaa";
        b= b.toLowerCase();

        System.out.println();
        System.out.println(a.contains(b));
        System.out.println(a);
    }

    public static int solution(String myString, String pat) {
        boolean isContain = false;
        int result = 0;

        myString = myString.toLowerCase();
        pat = pat.toLowerCase();

        isContain = myString.contains(pat);

        if(isContain) {
            result = 1;
        }

        return result;
    }
}
