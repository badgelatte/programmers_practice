import java.util.Arrays;

public class divideArr {
    public static void main(String[] args) {
        int[] arr = solution(new int[]{0,1,2,3,4,5}, new int[]{4,1,2});
        for(int num : arr) {
            System.out.println(num + " ");
        }
    }

    public static int[] solution(int[] arr, int[] query) {
        for(int i = 0; i < query.length; i++) {
            if(i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
            else {
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            }
        }

        return arr;
    }
}
