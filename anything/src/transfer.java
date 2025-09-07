public class transfer {
    public static void main(String[] args) {
        int a = solution(new String[]{"ayaye", "aya", "yee", "u", "maa", "wyeoo"});

        System.out.println(a);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for(String d : babbling) {
            for(String word : words) {
                if(d.contains(word)) {
                    d = d.replace(word, ",");
                }
            }
            d = d.replace(","," ");
            if(d.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
