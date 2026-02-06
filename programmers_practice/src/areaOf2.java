public class areaOf2 {
    public static void main(String[] args) {
        int[] arr = solution(new int[]{1,2,1,4,5,2,9});
        for (int num : arr) {
            System.out.print(num + " ");
            // {2,1,4,5,2}
        }
    }

    public static int[] solution(int[] arr) {
        int start = -1;
        int end = -1;

        for(int i = 0; i < arr.length; i++) {
            // start 지점 저장
            if(arr[i] == 2 && start < 0) {
                start = i;
            }
            // 2번째 2 지점 저장
            else if(start >= 0 && arr[i] == 2) {
                end = i;
            }
        }

        if(start != -1) {
            return arrSub(arr, start, end);
        }
        return new int[]{-1};
    }

    public static int[] arrSub(int[] arr, int start, int end) {
        int[] result = new int[end-start+1];
        int now = 0;

        for(int i = start; i <= end; i++) {
            result[now++] = arr[i];
        }

        return result;
    }
}
