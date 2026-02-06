import java.util.ArrayList;
import java.util.List;

public class filterAndExpandBySelfCount {
    public static void main(String[] args) {
        int[] arr = solution(
                new int[]{3,2,4,1,3},
                new boolean[]{true,false,true, false, false}
                );
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int[] arr, boolean[] flag) {
        int[] trueArr = onlyTrueArr(arr, flag);
        int length = sumElement(trueArr);
        int[] result = new int[length];
        int now = 0;

        for(int i = 0; i < trueArr.length; i++) {
            result = fillWithAmount(now, trueArr[i], result);
            now += trueArr[i];
        }

        return result;
    }

    public static int[] onlyTrueArr(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList();

        for(int i = 0; i < arr.length; i++) {
            if(flag[i]) {
                list.add(arr[i]);
            }
        }

        return listToArr(list);
    }

    public static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static int sumElement(int[] arr) {
        int count = 0;

        for(int num : arr) {
            count += num;
        }

        return count;
    }

    public static int[] fillWithAmount(int start, int amount, int[] arr) {
        for(int i = start; i < start + amount; i++) {
            arr[i] = amount;
        }

        return arr;
    }
}
