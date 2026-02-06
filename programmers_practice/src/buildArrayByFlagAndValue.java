import java.util.ArrayList;
import java.util.List;

public class buildArrayByFlagAndValue {
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
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < flag.length; i++) {
            if(flag[i]) {
                listAddWithAmount(arr[i], list);
            }
            else {
                listRemoveWithAmount(arr[i], list);
            }
        }

        return listToArr(list);
    }

    public static void listAddWithAmount(int amount, List<Integer> list) {
        int now = amount * 2;

        while(now-- > 0) {
            list.add(amount);
        }
    }

    public static void listRemoveWithAmount(int amount, List<Integer> list) {
        int now = amount;

        while(now-- > 0) {
            list.removeLast();
        }
    }

    public static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
