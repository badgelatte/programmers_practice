class reverseStrSeveral {
    public static void main(String[] args) {
        System.out.println(solution("rermgorpsam", new int[][] {{2,3},{0,7},{5,9},{6,10}}));
    }

    public static String solution(String my_string, int[][] queries) {
        String[] letters = my_string.split("");
        
        for(int[] query : queries) {
            String temp = "";
            for(int i = 0; i < ((query[1]-query[0])/2+1);i++) {
                temp = letters[query[0]+i];
                letters[query[0]+i] = letters[query[1]-i];
                letters[query[1]-i] = temp;
            }
            System.out.println(query[0]+", "+query[1]+" "+makeString(letters));
        }
        
        return makeString(letters);
    }
    
    public static String makeString(String[] letters) {
        String result = "";
        
        for(String letter : letters) {
            result += letter;
        }
        
        return result;
    }
}
