public class BubbleSort {

  // O(n^2) runtime and O(1) space complexities.
  // Stable sort
  public static int[] bubbleSort(int[] arr) {
    int n = arr.length;

    for (int i = n-1; i > 0; i--) { // i is the last unsorted index
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
        }
      }
    }
    return arr;
  }

  // Best for nearly sorted list
  public static int[] bubbleSort2(int[] arr) {
    int n = arr.length;
    boolean swapped;
    for (int i = n-1; i > 0; i--) {
      swapped = false;
      for(int j = 0; j < i; j++) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    return arr;
  }

  public static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  public static String print(int[] arr) {
    String result = "[";
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      result += arr[i] + ", ";
    }
    if (n > 0) {
      result += arr[n-1];
    }
    result += "]";
    return result;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {7, 3, -2, 8, 2, -1, 0};
    System.out.println("Before sorting, arr = " + print(arr));
    int[] sortedArr = bubbleSort(arr);
    System.out.println("After sorting, arr = " + print(sortedArr));
    int[] sortedArr2 = bubbleSort(arr);
    System.out.println("Using bubbleSort2, arr = " + print(sortedArr2));
  }
}
