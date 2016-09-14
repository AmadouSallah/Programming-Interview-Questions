/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Follow up: What if the input array is sorted in ascending order?
*/

import java.util.HashMap;
import java.util.Map;

public class twoSum {

  public static int[] twoSum(int[] nums, int target) {

    if ( (nums == null) || (nums.length == 0) ) {
      return new int[0];
    }

    int n = nums.length;
    int[] result = new int[2];
    Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {

      int currentElement = nums[i];
      int difference = target - currentElement;

      if (hashmap.containsKey(difference)) {

        result[0] = hashmap.get(difference);
        result[1] = i;
        break;

      } else {
        hashmap.put(currentElement, i);
      }
    }

    return result;
  }

  // Follow up: What if input array is sorted in ascending order (Problem 167)
  public static int[] twoSumII(int[] nums, int target) {
    // We assume nums is sorted in ascending order:
    int len = nums.length, left = 0, right = len - 1;
    int[] result = new int[2];

    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum < target)
        // Decreasing right will not help since it will make sum even smaller. So we increment left
        left++;
      else if (sum > target)
        // Increasing left will not help since it will make sum even bigger. So we decrement right
        right--;
      else { // sum = target
        // We have found the answer
        result[0] = left;
        result[1] = right;
        break;
      }
    }
    return result;
  }

  public static String printArray(int[] arr) {
        String s = "[";
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            s += arr[i] + ", ";
        s += (n > 0) ? (arr[n-1] + "]") : "]";
        return s;
    }

  public static void main(String[] args) {

    System.out.println("twoSum(new int[] {}, 9): " + printArray(twoSum(new int[] {}, 9)));
    System.out.println("twoSum(new int[] {1}, 9): " + printArray(twoSum(new int[] {1}, 9)));
    System.out.println("twoSum(new int[] {2, 7}, 9): " + printArray(twoSum(new int[] {2, 7}, 9)));
    System.out.println("twoSum(new int[] {2, 15, 11, 7}, 9): " + printArray(twoSum(new int[] {2, 15, 11, 7}, 9)));

    System.out.println("\nCases where the input array is sorted:");
    System.out.println("twoSumII(new int[] {}, 9): " + printArray(twoSumII(new int[] {}, 9)));
    System.out.println("twoSumII(new int[] {1}, 9): " + printArray(twoSumII(new int[] {1}, 9)));
    System.out.println("twoSumII(new int[] {2, 7}, 9): " + printArray(twoSumII(new int[] {2, 7}, 9)));
    System.out.println("twoSumII(new int[] {2, 7, 9, 11}, 9): " + printArray(twoSumII(new int[] {2, 15, 11, 7}, 9)));
  }

}

/*
Older one:
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers
(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/


/*
 SOLUTION 1: 0(n^2) running time and 0(1) space

Pseudocode:
We go through the input array from the begining. For each array element, we go through the
rest of the array elements to see if there is an element whose sum with the current element
adds up to the target. If so, these 2 elements are the ones we are looking for.
We then print each of their indexes + 1 (since it's not zero based, we add 1 to each index).

*/
/*
import java.util.HashMap;

class TwoSum {

  public static void main(String[] args) {
    int[] array = {2, 7, 11, 15};
    twoSum1(array, 9);  // index1=1, index2=2
    twoSum1(array, 13); // index1=1, index2=3
    twoSum1(array, 17); // index1=1, index2=4
    twoSum1(array, 18); // index1=2, index2=3
    twoSum1(array, 22); // index1=2, index2=4

    System.out.println("Testing the 2nd solution: 0(n) running time and 0(n) space complexities");
    twoSum2(array, 9);  // index1=1, index2=2
  }

  public static void twoSum1(int[] numbers, int target) {
    int len = numbers.length;
    for(int i = 0; i < len; i++) {
      int element = numbers[i];
      for(int j = i+1; j < len; j++) {
        if(element + numbers[j] == target) {
          System.out.println("index1=" + (i+1) + ", index2=" + (j+1) );
          return;
        }
      }
    }
  }

  public static void twoSum2(int[] numbers, int target) {
    HashMap myHashMap = new HashMap();
    int len = numbers.length;

    for(int i = 0; i < len; i++) {
      int element = numbers[i];
      int key = target - element;
      // int value = myHashMap.get(key);

      if(myHashMap.get(key) != null) {
        int index1 = numbers.indexOf(target) + 1;
        System.out.println("index1=" + index1 + ", index2=" + (i+1));
      } else {
        myHashMap.put(key, value);
      }
    }
  }
}
*/

