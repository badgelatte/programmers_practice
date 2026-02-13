import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 구름 - 방 탈출하기
// https://level.goorm.io/exam/49105/%EB%B0%A9-%ED%83%88%EC%B6%9C%ED%95%98%EA%B8%B0/quiz/1
public class escapeRoom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sequenceNum = br.readLine();
        String[] sequence = br.readLine().split(" ");
        int numberLen = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        Set<String> sequenceSet = new HashSet<>(Arrays.asList(sequence));

        for (int i = 0; i < numberLen; i++) {
            if (sequenceSet.contains(numbers[i])) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}