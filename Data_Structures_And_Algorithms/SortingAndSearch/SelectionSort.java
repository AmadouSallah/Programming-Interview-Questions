public class SelectionSort {

  // O(n^2) runtime, O(1) space complexities.
  // Not Stable
  public static int[] selectionSort(int[] arr) {
    int n = arr.length, minIndex;
    for (int i = 0; i < n; i++) {
      minIndex = i;
      for (int j = i+1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, minIndex, i);
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
    System.out.println("After sorting, arr = " + print(selectionSort(arr)));
  }
}
