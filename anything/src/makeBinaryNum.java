class makeBinaryNum {
    public static void main(String[] args) {
        System.out.println(solution("1111111111", "1111111111"));
        System.out.println(solution("1001", "11111"));
    }

    public static String solution(String bin1, String bin2) {
        int num1 = Integer.parseInt(bin1);
        int num2 = Integer.parseInt(bin2);
        long sum = (long)num1 + num2;
        
        long[] bins = new long[String.valueOf(sum).length()+1];
        int length = bins.length - 1;
        
        while(sum > 0) {
            if(sum % 10 >= 2) {
                bins[length--] = sum % 10 -2;
                sum = sum / 10 + 1;
            }
            else {
                bins[length--] = sum % 10;
                sum /= 10;
            }
        }
        
        sum = 0;
        for(int i = 0; i < bins.length; i++) {
            sum = sum * 10 + bins[i];
        }
        
        return String.valueOf(sum);
    }

}
