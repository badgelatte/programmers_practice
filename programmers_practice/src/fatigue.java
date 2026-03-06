import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class fatigue {
    public static void main(String[] args) {
        fatigue f = new fatigue();
        String[] arr
//                = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
                = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String answer = f.solution(8,2, arr);
        System.out.println(answer);
    }
    public String solution(int n, int k, String[] cmd) {
        List<Integer> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        int num = 0;

        for(String a : cmd) {
            if(a.equals("C")) {
                list.add(k);
                n--;
            }
            else if(a.equals("Z")) {
                list.remove(list.size()- 1);
                n++;
            }
            else if(a.contains("U")) {
                num = Integer.parseInt(a.split(" ")[1]);
                k -= num;
                if(k > n) {
                    k += n;
                }
            }
            else if(a.contains("D")) {
                num = Integer.parseInt(a.split(" ")[1]);
                k += num;
                if(k < 0) {
                    k -= n;
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        num = 0;
        n += list.size();

        for (int i = 0; i < n; i++) {
            if (!list.isEmpty() && i == list.get(num)) {
                answer.append("X");
                list.removeFirst();
            }
            else {
                answer.append("O");
            }
        }

        return answer.toString();
    }
}
