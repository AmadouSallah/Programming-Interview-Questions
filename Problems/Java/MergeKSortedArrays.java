/* Merge k sorted arrays */

import java.util.PriorityQueue;
import java.util.Arrays;

public class MergeKSortedArrays {

  public static class Tuple implements Comparable<Tuple> {
    int[] array;
    int index;

    public Tuple(int[] array, int index) {
      this.array = array;
      this.index = index;
    }

    @Override
    public int compareTo(Tuple t) {
      return this.array[this.index] - t.array[t.index];
    }
  }

  public static int[] mergeKSortedArrays(int[][] nums) {

    PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
    int n = nums.length, totalLength = 0;

    // add all inner arrays to minHeap with index 0
    for (int i = 0; i < n; i++) {
      Tuple currentTuple = new Tuple(nums[i], 0);
      minHeap.add(currentTuple);
      totalLength += nums[i].length;
    }

    int k = 0;
    int[] result = new int[totalLength];

    while (!minHeap.isEmpty()) {
      Tuple topTuple = minHeap.poll();
      result[k++] = topTuple.array[topTuple.index];
      if (topTuple.index < topTuple.array.length - 1) {
        minHeap.add(new Tuple(topTuple.array, topTuple.index + 1));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 5, 7, 11}, arr2 = {2, 4, 6, 7, 8}, arr3 = {0, 3, 10, 15};
    int[][] matrix = new int[][] {arr1, arr2, arr3};

    int[] res = mergeKSortedArrays(matrix);
    System.out.println(Arrays.toString(res));
  }
}
// Resources: https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
