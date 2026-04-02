import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class leetcode_twoPointerPatter {
    public static void main(String[] args) {
        // 167
        int[] arr167 = twoSum(new int[]{2,7,11,15}, 9);
        printArr(arr167);

        // 349
        int[] arr349 = intersection(new int[]{1,2,2,1}, new int[] {2,2});
        printArr(arr349);

        List<List<Integer>> list = threeSum(
//                new int[]{-1,0,1,2,-1,-4})
                new int[]{0,0,0}
        );
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // 633
        System.out.println(judgeSquareSum(2147483600));

        // 283
        int[] arr283 = moveZeroes(
//                new int[]{0,1,0,3,12}
//                new int[]{2, 1, 0}
//                new int[]{0}
//                new int[]{1, 0}
                new int[]{0, 0, 1}
        );
        printArr(arr283);

        // 977
        int[] arr977 = makePow(new int[]{-7,-3,2,3,11});
        printArr(arr977);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node2;

        System.out.println(detectCycle(node1).val);

    }

    public static void printArr (int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    // 977
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.pow(nums[i], 2));
        }

        Arrays.sort(nums);

        return nums;
    }

    // 349
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int count = 0;

        for (int num : resultSet) {
            result[count++] = num;
        }

        return result;
    }

    public static Set<Integer> intArrToSet (int[] arr) {
        Set<Integer> set = new HashSet<Integer>();

        for (int j : arr) {
            set.add(j);
        }

        return set;
    }

    // 167
    public static int[] intersection1 (int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(i);
                    break;
                }
            }
        }

        int[] resultArr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultArr[i] = list.get(i);
        }

        return resultArr;
    }

    // 167 시간 복잡도 O(n)
    public int[] intersection2(int[] nums1, int[] nums2) {
        int count1 = 0;
        int count2 = 0;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (count1 < nums1.length && count2 < nums2.length) {
            if (nums1[count1] == nums2[count2] && !list.contains(nums1[count1])) {
                list.add(nums1[count1++]);
                count2++;
            } else if (nums1[count1] < nums2[count2]) {
                count1++;
            } else {
                count2++;
            }
        }

        int[] resultArr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultArr[i] = list.get(i);
        }

        return resultArr;
    }

    // 167 시간 복잡도 O(n^2)
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;

                    return result;
                }
            }
        }

        return result;
    }

    // 167 시간 복잡도 O(n)
    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[1] = i + 1;
                    result[0] = j + 1;

                    return result;
                }
            }
        }

        return result;
    }

    // 15
    public static List<List<Integer>> threeSum(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int sum = 0;

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sum0 = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            start = i + 1;
            end = nums.length -1;

            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    sum0 = new ArrayList<>();
                    sum0.add(nums[i]);
                    sum0.add(nums[start]);
                    sum0.add(nums[end]);
                    list.add(sum0);
                    while (start < nums.length -1 && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (end > 1 && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return list;
    }

    // 633
    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.sqrt(c);
        long sum = 0;

        while (start <= end) {
//            sum = (long)(Math.pow(start, 2)) + (long)(Math.pow(end, 2));

            sum = (long) start * start + (long) end * end;
            if (sum > c) {
                end--;
            } else if (sum < c) {
                start++;
            } else {
                return true;
            }
        }

        return false;
    }

    // 283
    public static int[] moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                queue.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty()) {
                nums[i] = queue.poll();
            } else {
                nums[i] = 0;
            }
        }

        return nums;
    }

    // 283
    public static int[] moveZeroes2(int[] nums) {
        int zeroPoint = -1;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPoint = i;
                break;
            }
        }
        if (zeroPoint < 0 || zeroPoint == nums.length - 1) {
            return nums;
        }

        for (int i = 0; i < nums.length && zeroPoint < nums.length; i++, zeroPoint++) {
            if (i == zeroPoint) {
                i++;
            }
            while (i < nums.length - 1 && nums[i] == 0) {
                i++;
            }

            temp = nums[zeroPoint];
            nums[zeroPoint] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

    // 977
    public static int[] makePow(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = result.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) < nums[end]) {
                result[i] = (int) Math.pow(nums[end--], 2);
            } else {
                result[i] = (int) Math.pow(nums[start++], 2);
            }
        }

        return result;
    }

    // 142
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
