/*

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


