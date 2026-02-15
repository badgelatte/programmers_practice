import java.io.*;
import java.math.BigInteger;

/*
* 100을 팩토리얼로 돌리면 int, long으론 돌리기 불가
* 범위를 넘어서기 때문에 BigInteger 사용 -> BigInteger = 정밀한 정수 / BigDecimal = 정밀한 실수
* 기존 재귀함수를 사용할 시 스택 오버플로우가 뜬다
* -> 함수 호출할 때마다 스택 메모리가 쌓이는데, 너무 깊은 재귀 호출은 메모리 초과하기 때문
* 이를 위한 해결법으로 반복문 사용으로 방식을 변경
* */
public class bigFactorial {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        BigInteger num = new BigInteger(input);
        num = factorial(num);

        System.out.println(num.remainder(BigInteger.valueOf(1000000007)));
    }

    public static BigInteger factorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for(int i = 1;;i++) {
            result = result.multiply(BigInteger.valueOf(i));

            if(num.equals(BigInteger.valueOf(i))) {
                break;
            }
        }

        return result;
    }
}