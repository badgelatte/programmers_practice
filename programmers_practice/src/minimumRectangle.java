public class minimumRectangle {
    public static void main(String[] args) {
        int[][] sizes = new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        
        System.out.println(solution(sizes));

    }

    public static int solution(int[][] sizes) {

        for(int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];

            if(size[0] < size[1]) {
                sizes = swap(sizes, i);
            }
        }

        int maxWidth = findMax(sizes, 0);
        int maxLength = findMax(sizes, 1);

        return maxWidth * maxLength;
    }

    public static int[][] swap(int[][] arr, int num) {
        int temp = 0;

        temp = arr[num][0];
        arr[num][0] = arr[num][1];
        arr[num][1] = temp;
        
        return arr;
    }

    public static int findMax(int[][] arr, int column) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i][column]) {
                max = arr[i][column];
            }
        }

        return max;
    }
}