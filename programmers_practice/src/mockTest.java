public class mockTest {
    public static void main(String[] args) {
        int[] answers1 = new int[]{1,2,3,4,5};
        int[] answers2 = new int[]{1,3,2,4,2};
        int[] result = solution(answers2);

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
        String topScore = 1 + ",";
        int top = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(top < arr[i]) {
                topScore = (i + 1) + ",";
            }
            else if(top == arr[i]) {
                topScore += (i + 1 + ",");
            }
        }

        return strToIntArr(topScore);
    }

    public static int[] strToIntArr(String str) {
        String[] strArr = str.split(",");
        int[] intArr = new int[strArr.length];
        System.out.println(str);

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        return intArr;
    }


}
