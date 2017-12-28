/*
Problem 215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

import java.util.PriorityQueue;

public class FindKthLargest {

    // Solution 1: Using Quick Select
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length, left = 0, right = n-1, indexOfK = n-k;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == indexOfK) {
                return nums[pivot];
            } else if (pivot < indexOfK) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return nums[left];
    }

    // Resources for partition: https://www.youtube.com/watch?v=MZaf_9IZCrc
    public static int partition(int[] nums, int left, int right) {
        int pivotElement = nums[right], i = left-1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotElement) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Solution 2: Using a Min Heap:
    /*
    Using a Min Heap:
    1) Create a Min Heap of size k and add to it the 1st k elements of the input array, nums
    2) For all the remaining elements from k to the end:
      if the current array element is > the top element of the min heap (the smallest element of the heap),
      then replace this top element by the current array element (heap will heapify)
    3) At the end, the Min Heap will have the kth largest element of the as its top element.
    So we return this top element
    */

    public static int findKthLargest2(int[] nums, int k) {
      if (nums == null || nums.length == 0) return -1;

      int n = nums.length;
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
      // For a Max Heap, we initialize as:
      // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n2, n1));

      // Add the first k elements to minHeap
      for (int i = 0; i < k; i++) {
        minHeap.add(nums[i]);
      }

      // For all elements from k to n-1, we only add to minHeap those that are > the top element of the minHeap
      for (int i = k; i < n; i++) {
        int topElement = minHeap.peek();
        if (topElement < nums[i]) {
          minHeap.poll(); // or minHeap.remove(topElement)
          minHeap.add(nums[i]);
        }
      }

      // At this point, the kth largest element is the top element of minHeap, so wer return it.
      return minHeap.peek();
    }

    public static void printArray(int[] arr) {
      String s = "[";
      int n = arr.length;
      for (int i = 0; i < n-1; i++)
          s += arr[i] + ", ";
      s += (n > 0) ? (arr[n-1] + "]") : "]";
      System.out.println(s);
    }

    public static void main(String[] args) {
      int[] arr1 = {3,2,1,5,6,4};
      System.out.print("Input array = ");
      printArray(arr1);

      System.out.println("\nUsing solution with Quik Select");
      System.out.println("1st largest element from array is: " + findKthLargest(arr1, 1));
      System.out.println("2nd largest element from array is: " + findKthLargest(arr1, 2));
      System.out.println("3rd largest element from array is: " + findKthLargest(arr1, 3));
      System.out.println("6th largest element from array is: " + findKthLargest(arr1, 6));

      System.out.println("\nUsing solution with Min Heap");
      System.out.println("1st largest element from array is: " + findKthLargest2(arr1, 1));
      System.out.println("2nd largest element from array is: " + findKthLargest2(arr1, 2));
      System.out.println("3rd largest element from array is: " + findKthLargest2(arr1, 3));
      System.out.println("6th largest element from array is: " + findKthLargest2(arr1, 6));
    }

}
