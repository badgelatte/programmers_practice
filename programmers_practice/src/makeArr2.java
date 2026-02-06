import java.util.ArrayList;
import java.util.List;

public class makeArr2 {
    public static void main(String[] args) {
        int[] a = solution2(5, 555);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] b = solution2(1, 100000);
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution2(int l, int r) {
        int count = 0;
        int num = 0;
        List<Integer> list = new ArrayList<>();

        while(num < l) {
            num = makeBinary(count++) * 5;
        }

        while(num < r) {
            list.add(num);
            num = makeBinary(count++) * 5;
        }

        return listToArr2(list);
    }

    public static int[] listToArr2(List<Integer> list) {
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }

    public static int makeBinary(int num) {
        String binaryStr = Integer.toBinaryString(num);
        return Integer.parseInt(binaryStr);
    }

    public static int[] solution(int l, int r) {
        List<String> list = new ArrayList();
        l /= 5;
        r /= 5;
        int decimal_r = Integer.parseInt(""+r,2);
        // System.out.println(Integer.parseInt("111",2));
        
        while(decimal_r>= l) {
            String binaryString = Integer.toBinaryString(l++);
            list.add(binaryString);
        }
        
        if(list.isEmpty()) {
            list.add("-1");
        }
        return listToArr(list);
    }
    
    public static int[] listToArr(List<String> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = Integer.parseInt(list.get(i)) * 5;
        }
        
        return arr;
    }
}
