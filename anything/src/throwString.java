class Solution {

    public int others2_solution(String A, String B) {

        return (B+B).indexOf(A);
    }

    public int others_solution(String A, String B) {
        String tempB = B.repeat(3);
        return tempB.indexOf(A);
    }

    public static int my_solution(String A, String B) {
        if(isSame(A,B)) {
            return 0;
        }
        
        int count = A.length();
        String[] ALetters = A.split("");
        
        while(++count < A.length()) {
            if(B.equals(moveRight(ALetters))) {
                return 1;
            }
        }
        
        return -1;
    }
    
    public static boolean isSame(String A, String B) {
        return A.equals(B);
    }
    
    public static String moveRight (String[] letters){
        String temp = "";
        
        for(int i = letters.length - 1; i > 0; i--) {
            temp = letters[i];
            letters[i] = letters[i-1];
            letters[i-1] = temp;
        }
        
        return arrToStr(letters);
    }
    
    public static String arrToStr(String[] letters) {
        StringBuilder sb = new StringBuilder();
        
        for(String letter : letters) {
            sb.append(letter);
        }
        
        return sb.toString();
    }
}