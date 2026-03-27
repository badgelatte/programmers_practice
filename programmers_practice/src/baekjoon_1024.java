import java.util.Scanner;

public class baekjoon_1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        int count = sc.nextInt();
        boolean find = false;

        long avg = num / count;
        int sum = 0;
        int min;

        if (num < 1) {
            min = Math.toIntExact(Math.min(100, count));
        } else {
            min = Math.toIntExact(Math.min(100, num));
        }

        long startLoc = 0;

        for (; count <= min; count++) {
            avg = num / count;

            if(count % 2 == 0) {
                if (avg * count - count/2 == num) {
                    find = true;
                    startLoc = avg - count / 2;
                    break;
                } else if(avg * count + count/2 == num) {
                    find = true;
                    startLoc = avg - count / 2 + 1;
                    break;
                }
            } else {
                if (avg * count == num) {
                    find = true;
                    startLoc = avg - count/2;
                    break;
                }
            }
        }

        if (!find || startLoc < 0) {
            System.out.println(-1);
            return;
        }

        String result = "";

        for (int i = 0; i < count; i++, startLoc++) {
            result += startLoc + " ";
        }

        System.out.println(result.substring(0, result.length() - 1));
    }
}
