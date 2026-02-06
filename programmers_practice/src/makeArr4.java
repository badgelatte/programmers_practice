import java.util.ArrayList;
import java.util.List;

class makeArr4 {
    public static void main(String[] args) {
        int[] a = solution(new int[] {1,4,2,5,3});
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList();
        int i = 0;

        while(i < arr.length) {
            if(stk.isEmpty()) {
                stk.add(arr[i++]);
            }
            else if(stk.getLast() < arr[i]) {
                stk.add(arr[i++]);
            }
            else if(stk.getLast() >= arr[i]) {
                stk.removeLast();
            }
        }
        
        return listToArr(stk);
    }
    
    public static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}
