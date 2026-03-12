import java.util.Scanner;

public class baekjoon_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = 1;
        int sum = 0;

        for (int i = 1; count <= end; i++) {
            for ( int j = 0; j < i; j++) {
                if(count > end) {
                    break;
                }
                if(count++ >= start) {
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }
}