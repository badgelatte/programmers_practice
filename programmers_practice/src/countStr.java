public class countStr {
    public static void main(String[] args) {
        System.out.println(solution("Programmers"));
    }
    public static int[] solution(String my_string) {
        int[] answer = new int[26];
        char[] charArr = my_string.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] < 97) {
                answer[charArr[i] - 65]++;
            }
            // -98 + 26  + 1 = 71 // 98 == 소문자 a 아스키 코드
            answer[charArr[i] - 71]++;
        }
        return answer;
    }
}
