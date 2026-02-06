public class spiralNum {
    public static void main(String[] args) {
        int n = 6;
        int[][] arr;
        arr = solution1(n);

        printArr(arr);
    }

    public static int calculateTurnPointStep(int n, int num, boolean isOdd) { // 홀
        int sum = n;

        if(sum == num) {
            return sum;
        }

        if(isOdd) {
            sum -= num;
        }

        for(;num < n; num++) {
            sum += num * 2;
        }

        return sum;
    }

    public static int[][] solution1(int n) {
        int[][] arr = new int[n][n];
        int row = 0;
        int column = 0;
        boolean isOdd = true;
        int way = 1;
        int stepCount = n;

        // n -> n 1번, n-1 2번, n-2 2번 ... 1 2번 이동

        for(int i = 1; i <= n * n; i++) {
            if(calculateTurnPointStep(n, stepCount, isOdd) == i) {
                if(n != stepCount) {
                    if(isOdd) {
                        isOdd = false;
                    }
                    else {
                        stepCount--;
                        isOdd = true;
                    }
                }
                else {
                    stepCount--;
                }
                // 1 right
                // 2 down
                // 3 left
                // 4 up
                way++;
                if(way >=5) {
                    way = 1;
                }
            }
            if(way == 1) {
                arr[row][column++] = i;
            }
            else if(way == 2) {
                arr[row++][column] = i;
            }
            else if(way == 3) {
                arr[row][column--] = i;
            }
            else if(way == 4) {
                arr[row--][column] = i;
            }
        }

        return arr;
    }

    // 6, 5,5, 4,4, 3,3, 2,2, 1,1,
    public static int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int row = 0;
        int column = 0;
        int rowWay = -1;
        int columnWay = 1;

// 0,0/ 0,3/ 4,3/ 4,0/ 1,0/ 1,2/ 3,2/ 3,1/ 2,1/ 2,2
        // row > 0 && column > 0 ->
        // column++
        // row > 0 && column < 0 down
        // row++;
        // row < 0 && column < 0 <-
        // column--;
        // row < 0 && column > 0 up
        // row--;
        // end 조건 : n * n 번호와 배열 채우는 숫자값 동일한 경우
        for(int i = 1; i <= n*n; i++) {
            if(rowWay < 0 && columnWay > 0) {
                arr[row][column++] = i;
                if(column >= n || arr[row][column] != 0) {
                    row++;
                    column--;
                    rowWay = 1;
                }
            }
            else if(rowWay > 0 && columnWay > 0) {
                arr[row++][column] = i;
                if(row >= n || arr[row][column] != 0) {
                    row--;
                    column--;
                    columnWay = -1;
                }
            }
            else if(rowWay > 0 && columnWay < 0) {
                arr[row][column--] = i;
                if(column < 0 || arr[row][column] != 0) {
                    row--;
                    column++;
                    rowWay = -1;
                }
            }
            else if(rowWay < 0 && columnWay < 0) {
                arr[row--][column] = i;
                if(row < 0 || arr[row][column] != 0) {
                    row++;
                    column++;
                    columnWay = 1;
                }
            }

            printArr(arr);
            System.out.println();

        }
        return arr;
    }

    public static void printArr(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println(" ]");
        }
    }
}
