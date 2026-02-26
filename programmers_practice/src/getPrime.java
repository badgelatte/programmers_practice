import java.util.*;

public class getPrime {
    public static void main(String[] args) {
//        solution("1234");
    }

    public static int solution1(String str) {
        String[] strings = str.split("");
        int[] nums = new int[strings.length + 1];
        Set<Integer> set = new HashSet<>();        // 최종 만들어진
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            set.add(Integer.parseInt(strings[i]));
            nums[i] = Integer.parseInt(strings[i]);
        }

        set.add(-1);
        nums[nums.length-1] = -1;
        // 여기까진 set, int[]에 숫자 들어옴
        // 1,2,3,4, -1

        int num = 0;

        for(int i = 0; i < nums.length -1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == -1) {
                    break;
                }
                if(nums[i] == nums[j]) {
                    continue;
                }
                num = num * 10 + nums[j];

                System.out.println(num);
            }
        }

        /*
        nums = 1,2,3,4,-1

        1
        i = 0 j = 0 num = continue
        i = 0 j = 1 num = 12

        i = 0 j = 2 num = 123
        i = 0 j = 3 num = 1234
        i = 0 j = 4 num = break

        list - 3 4
        i = 0 j = 2 num = 13

// -> list clone해서 사용한 수는 삭제 ㄱ

        2
        i = 1 j = 0 num = 21
        i = 1 j = 1 num = continue
        i = 1 j = 2 num = 213
        i = 1 j = 3 num = 2134
        i = 1 j = 4 num = break

        3
        i = 2 j = 0 num = 31
        i = 2 j = 1 num = 312
        i = 2 j = 2 num = continue
        i = 2 j = 3 num = 3124
        i = 2 j = 4 num = break

        i = 3 j = 0 num =
        i = 3 j = 1 num =
        i = 3 j = 2 num =
        i = 3 j = 3 num =
        i = 3 j = 4 num = break

        i = 4 j = 0 num =
        i = 4 j = 1 num =
        i = 4 j = 2 num =
        i = 4 j = 3 num =
        i = 4 j = 4 num = break
        * */

        return 0;
    }

    // 17 011
    static Set<Integer> set = new HashSet<>();
    public static int solution2(String numbers) {


        recursive("", numbers);

        Iterator<Integer> iterator = set.iterator();
        int number = 0;
        int count = 0;

        while(iterator.hasNext()) {
            number = iterator.next();
            if(isPrime(number)) {
                count++;
            }
        }

        return count;
    }

    public static void recursive(String start, String end) {
        if(!start.equals("")) {
            set.add(Integer.valueOf(start));
        }

        for(int i = 0; i < end.length(); i++) {
            recursive(start + end.charAt(i), end.substring(0, i) + end.substring(i + 1));
        }
    }

    public static boolean isPrime(int num) {
        int current = 1;

        if(num <= 1) {
            return false;
        }

        while(++current < num) {
            if(num % current == 0) {
                return false;
            }
        }

        return true;
    }
}

