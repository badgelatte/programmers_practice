import java.util.ArrayList;
import java.util.List;

public class makeArr5 {
    public static void main(String[] args) {
        int[] aa = solution(new String[]{"0123456789","9876543210","9999999999999"},50000,5,5);
        for (int j : aa) {
            System.out.println(j);
        }
    }

    public static int[] solution(String[] intStrs, int k, int l, int s) {
        List<Integer> list = new ArrayList<>();

        for(String intStr : intStrs) {
            StringBuilder str = new StringBuilder();
            for(int i = s; i < s+l; i++) {
                str.append(intStr.charAt(i));
                System.out.println(intStr.charAt(i));
            }
            System.out.println();
            int num = strToInt(str.toString());
            if(num > k) {
                list.add(num);
            }
        }

        return listToArr(list);
    }
    public static int strToInt(String str) {
        return Integer.parseInt(str);
    }

    public static int[] listToArr(List<Integer> list) {
        int[] results = new int[list.size()];

        for(int i = 0;i < list.size(); i++) {
            results[i] = list.get(i);
        }

        return results;
    }
}
