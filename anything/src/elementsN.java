public class elementsN {
    public static void main(String[] args) {
        int[] sol = solution(new int[]{4,2,6,1,7,6}, 4);
        for (int num : sol) {
            System.out.println(num + " ");
        }
    }

    public static int[] solution(int[] num_list, int n) {
        int length = isLen(num_list.length, n);
        int[] answer = new int[length];
        int now = 0;

        for(int i = 0; i < num_list.length; i+= n) {
            answer[now++] = num_list[i];
        }

        return answer;
    }

    public static int isLen(int length, int n) {
        if(length % n == 0) {
            return length / n;
        }

        return length / n + 1;
    }
}
