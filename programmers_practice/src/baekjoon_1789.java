import java.util.Scanner;

public class baekjoon_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = sc.nextLong();
        long num = 0;
        long count = 0;

        if (sum == 1 || sum == 2) {
            System.out.println(1);
            return;
        }

        for (count = 1; num + count <= sum; count++) {
            num += count;
        }

        System.out.println(count - 1);
    }
}
