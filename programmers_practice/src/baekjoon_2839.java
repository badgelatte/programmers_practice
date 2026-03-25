import java.util.Scanner;


public class baekjoon_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        for (int sugar5kg = sugar / 5; sugar5kg >= 0; sugar5kg--) {
            for (int sugar3kg = 0; 5 * sugar5kg + 3 * sugar3kg <= sugar; sugar3kg++) {
                if (sugar5kg * 5 + sugar3kg * 3 == sugar) {
                    System.out.println(sugar5kg + sugar3kg);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}