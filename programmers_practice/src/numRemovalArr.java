import java.io.BufferedReader;
import java.io.InputStreamReader;

// 구름 주어진 배열 중 특정 숫자를 제외한 경우의 정수 개수 완료
public class numRemovalArr {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int count = 0;

        for(int i = 0; i < input2.length; i++) {
            if(!input2[i].contains(input1[1])) {
                count++;
            }
        }

        System.out.println(count);
    }
}
