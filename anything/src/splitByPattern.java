import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class splitByPattern {
    public static void main(String[] args) {
        String[] arr1 = solution("baconlettucetomato");
        String[] arr2 = solution("abcd");
        String[] arr3 = solution("cabab");

        for(String a : arr1) {
            System.out.print(a + ",");
        }
    }

    public static String[] solution(String myStr) {
        List<String> list = new ArrayList();
        list.add(myStr);

        list = splitStr(list, "a");
        list = splitStr(list, "b");
        list = splitStr(list, "c");

        return listToArr(list);
    }

    public static List<String> splitStr(List<String> list, String pat) {
        int listSize = list.size();

        for(int i = 0; i < listSize; i++) {
            String str = list.removeFirst();
            String[] arr = str.split(pat);
            list = addArrToList(list, arr);
        }

        return list;
    }

    public static List<String> addArrToList (List<String> list, String[] arr) {
        for (String s : arr) {
            if (Objects.equals(s, "")) {
                continue;
            }

            list.add(s);
        }

        return list;
    }

    public static String[] listToArr(List<String> list) {
        if(list.isEmpty()) {
            return new String[] {"EMPTY"};
        }

        String[] arr = new String[list.size()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}

