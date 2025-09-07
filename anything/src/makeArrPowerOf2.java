public class makeArrPowerOf2 {
    public static void main(String[] args) {
        int[] arr = solution(new int[]{1,2,3,4,5,6,4,4,4});

        System.out.print("[");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");

    }
    public static int[] solution(int[] arr) {
//        double root = Math.sqrt(arr.length);

//        if(root == (int)root) {
//            return arr;
//        }

        int count = findPowerOf2(arr.length);
        int[] result = new int[count];

        System.arraycopy(arr, 0, result, 0, arr.length);

        return result;
    }

    public static int findPowerOf2 (double num) {
        int exponent = 0;
        double power = 0;

        while(num > power) {
            power = Math.pow(2, exponent++);
        }

        return (int) power;
    }
}
