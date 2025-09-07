public class cutList {
    public static void main(String[] args) {
        int[] result = solution(4, new int[]{1,5,2}, new int[]{1,2,3,4,5,6,7,8,9});
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int n, int[] slicer, int[] num_list) {
        int[] result = {};
        switch(n){
            case 1:
                result = makeArr(0, slicer[1], 1, num_list);
                break;
            case 2:
                result = makeArr(slicer[0], num_list.length - 1, 1, num_list);
                break;
            case 3:
                result = makeArr(slicer[0], slicer[1], 1, num_list);
                break;
            case 4:
                result = makeArr(slicer[0], slicer[1], slicer[2], num_list);
                break;
        }



        return result;
    }

    public static int[] makeArr(int start, int end, int value, int[] numList) {
        int length = 0;
        if((end - start + 1) % value == 0) {
            length = (end - start + 1) / value;
        }
        else {
            length = (end - start + 1) / value + 1;
        }
        int[] arr = new int[length];

        for(int i = 0; start <= end; i++) {
            arr[i] = numList[start];
            start += value;
        }

        return arr;
    }
}
