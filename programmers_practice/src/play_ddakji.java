import java.io.*;
import java.util.Arrays;

// 백준 14696번 딱지놀이
class play_ddakji {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());


        while (round-- > 0) {
            String input1 = br.readLine();
            String input2 = br.readLine();

            int[] arr1 = makeArr(input1.substring(2));
            int[] arr2 = makeArr(input2.substring(2));

            System.out.println(compareArrs(arr1, arr2));
        }

        System.out.println();
    }

    public static int[] makeArr(String str) {
        String[] strArr = str.split(" ");
        int length = strArr.length;
        int[] arr = new int[length];

        Arrays.sort(strArr);

        for(int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(strArr[length - i - 1]);
        }

        return arr;
    }

    public static String compareArrs(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int minLen = Math.min(arr1Len, arr2Len);

        for (int i = 0; i < minLen; i++) {
            if (arr1[i] > arr2[i]) {
                return "A";
            }
            else if (arr1[i] < arr2[i]) {
                return "B";
            }
        }

        if (arr1Len > minLen && arr2Len == minLen) {
            return "A";
        }
        if (arr1Len == minLen && arr2Len > minLen) {
            return "B";
        }

        return "D";
    }
}

