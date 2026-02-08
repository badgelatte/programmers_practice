import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mockTest {
    public static void main(String[] args) {
        int[] answers1 = new int[]{1,2,3,4,5};
        int[] answers2 = new int[]{1,3,2,4,2};
        int[] result = solution(answers1);

        System.out.print("[");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static int[] solution(int[] answers) {
        // 수포자 2 = 2,1,2,3,2,4,2,5 반복
        // 수포자 1 = 1,2,3,4,5 반복
        // 수포자 3 = 3,3,1,1,2,2,4,4,5,5 반복

        int[][] testAnswers = {{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] correctAnswers = new int[3];

        for(int i = 0; i < correctAnswers.length; i++) {
            correctAnswers[i] = compareAnswer(answers, testAnswers[i]);
        }

        return findTopScore(correctAnswers);
    }

    public static int compareAnswer(int[] answers, int[] testAnswer) {
        int currentIndex = 0;
        int count = 0;

        for (int answer : answers) {
            if (answer == testAnswer[currentIndex++]) {
                count++;
            }

            if (currentIndex == testAnswer.length) {
                currentIndex = 0;
            }
        }

        return count;
    }

    public static int[] findTopScore(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arrSort[arrSort.length - 1]) {
                list.add(i + 1);
            }
        }

        int[] topScore = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            topScore[i] = list.get(i);
        }

        return topScore;
    }
}
