import java.util.ArrayList;
import java.util.List;

// 주어진 숫자에 대한 소인수 구하기
public class getPrimeNum {
    public static List<Integer> getPrimeNum(int num) {
        List<Integer> primeNumList = new ArrayList<>();
        int prime = 2;

        while(num < 2) {
            if(num % prime == 0) {
                primeNumList.add(prime);
                num /= prime;
            } else {
                prime++;
            }
        }

        return primeNumList;
    }
}
