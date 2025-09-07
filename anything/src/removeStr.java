public class removeStr {
    public static String solution(String my_string, int[] indices) {
        char[] strArr = my_string.toCharArray();

        for(int num : indices) {
            strArr[num] = ' ';
        }

        return charToStr(strArr);
    }

    public static String charToStr(char[] arr) {
        String str = "";

        for(char c : arr) {
            if(c == ' ') {
                continue;
            }
            str += c;
        }

        return str;
    }
}
