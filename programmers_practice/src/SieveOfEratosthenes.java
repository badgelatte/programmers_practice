import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int num = 100;
        List<Integer> list = removePrime(num);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) +" ");
        }
    }

    public static List<Integer> removePrime(int input) {
        List<Integer> list = new ArrayList<>();
        boolean flag = true;

        for (int i = 2; i < input; i++) {
            for (int num: list) {
                if (i % num == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
            flag = true;
        }

        return list;
    }

    public static boolean getPrime(int num) {
        if(num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
