import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fatigue {
    public static void main(String[] args) {
        fatigue f = new fatigue();
        String[] arr
//                = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
                = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
//                  = new String[]{"C", "C", "C", "C", "Z"};
        String answer = f.solution(8,2, arr);
        System.out.println(answer);
    }
    public String solution(int n, int k, String[] cmd) {
        List<Integer> removeNums = new ArrayList<>();
        String[] strArr = new String[n];
        Arrays.fill(strArr, "O");
        StringBuilder answer = new StringBuilder();
        int num = 0;

        for(String a : cmd) {
            if(a.equals("C")) {
                strArr[k] = "X";
                removeNums.add(k++);
                if (k >= n) {
                    k -= 2;
                }
            }
            else if(a.equals("Z")) {
                num = removeNums.remove(removeNums.size()- 1);
                strArr[num] = "O";
            }
            else if(a.contains("U")) {
                num = Integer.parseInt(a.split(" ")[1]);
                k -= num; // -> 이걸 for문 앞으로 두고 조건문을 바꿀까? k가 0이전이면 그만큼 n에서 뺀만큼 뒤에서 비교하면 되잖아
                // 만일 k = 0인데 7이 X이고 U 2 / n = 8 -> 이럴때 못 잡아냄
                for (int removeNum : removeNums) {
                    if (k < 0) {
                        if (removeNum < k + num || (k + n <= removeNum && removeNum < n)) {
                            k--;
                        }
                    }
                    else if (k + num < removeNum && removeNum <= k) {
                        k--;
                    }
                }

                if(k < 0) {
                    k += n;
                }

                if (strArr[k].equals("X")) {
                    k--;
                }
            }
            else if(a.contains("D")) {
                num = Integer.parseInt(a.split(" ")[1]);
                k += num;
                for (int removeNum : removeNums) {
                    if (k >= n) {
                        if (removeNum <= k - num ||(k - num < removeNum && removeNum < n)) {
                            k++;
                        }
                    }
                    else if (k + num >= removeNum && removeNum > k) {
                        k++;
                    }
                }

                if(k >= n) {
                    k -= n;
                }

                if (strArr[k].equals("X")) {
                    k++;
                }
            }
        }

        for (String str : strArr) {
            answer.append(str);
        }

        return answer.toString();
    }
}
