import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class diceGame {
    public static void main(String[] args) {
        System.out.println(solution(4,4,1,4));
        System.out.println(solution(6,3,3,6));
    }

    public static int solution(int a, int b, int c, int d) {
        Set<Integer> points = new HashSet<>(List.of(a,b,c,d));

        if(points.size() == 1) {
            return a * 1111;
        }
        if(points.size() == 2) {
            int[] pointArr = setToArr(points);
            int count = 0;
            
            if(pointArr[0] == a) count++;
            if(pointArr[0] == b) count++;
            if(pointArr[0] == c) count++;
            if(pointArr[0] == d) count++;

            if(count == 1) {
                return (int)Math.pow(10 * pointArr[1] + pointArr[0], 2);
            }
            if(count == 3) {
                return (int)Math.pow(10 * pointArr[0] + pointArr[1], 2);
            }

            return (pointArr[0] + pointArr[1]) * Math.abs(pointArr[0] - pointArr[1]);
        }
        if(points.size() == 3) {
            int[] pointArr = {a,b,c,d};

            for (int i = 0; i < pointArr.length; i++) {
                for (int j = i + 1; j < pointArr.length; j++) {
                    if(i == j) {
                        continue;
                    }
                    if(pointArr[i] == pointArr[j]) {
                        points.remove(pointArr[i]);
                        int[] remainPoint = setToArr(points);
                        return remainPoint[0] * remainPoint[1];
                    }
                }
            }

        }
        return findMin(List.of(a,b,c,d));
    }

    public static int findMin(List<Integer> list) {
        return Collections.min(list);
    }

    public static int[] setToArr(Set<Integer> points) {
        int[] arr = new int[2];
        Iterator<Integer> iterator = points.iterator();
        arr[0] = iterator.next();
        arr[1] = iterator.next();

        return arr;
    }
}
