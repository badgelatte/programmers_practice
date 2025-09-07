class App {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("a1b234b1"));
    }

    public static int solution(String my_string) {
        char[] charList = my_string.toCharArray();
        int temp = 0;
        int result = 0;

        for(int i = 0; i < charList.length - 1; i++) {
            if(Character.isDigit(charList[i])) {
                if(Character.isDigit(charList[i+1])) {
                    temp = temp * 10 + (charList[i] - 48);
                }
                else if(temp != 0) {
                    result += temp * 10 + (charList[i] - 48) ;
                }
                else {
                    result += (charList[i] - 48);
                }
            }
        }
        if(Character.isDigit(charList[charList.length - 1])) {
            result += (charList[charList.length - 1] - 48);
        }
        return result;
    }
}
