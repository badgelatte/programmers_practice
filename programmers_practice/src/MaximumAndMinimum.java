import java.util.Arrays;

public class MaximumAndMinimum {
    public static void main(String[] args) {
        maxiumAndminiMum("-1 2 4");
    }

    public static String maxiumAndminiMum (String s) {
        String[] splitS = s.split(" ");
        int[] nums = new int[splitS.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(splitS[i]);
        }

        Arrays.sort(nums);

        return nums[0] + " " + nums[nums.length - 1];
    }
}
