import java.util.Arrays;

public class AddMissingNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    public static int solution(int[] numbers) {
        int count = 0;
        int sum = 0;

        Arrays.sort(numbers);

        for (int number : numbers) {
            while (count++ != number) {
                sum += count - 1;
            }

        }

        while (count != 10) {
            sum += count++;
        }

        return sum;
    }
}