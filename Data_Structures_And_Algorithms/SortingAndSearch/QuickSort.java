public class QuickSort {

  public static int[] quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
    return arr;
  }

  private static void quickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivotIndex = partition(arr, start, end);
    quickSort(arr, start, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, end);
  }

  private static int partition(int[] arr, int start, int end) {
    int pivotElement = arr[end], i = start - 1;
    for (int j = start; j < end; j++) {
      if (arr[j] < pivotElement) {
        i++;
        swap(arr, i, j);
      }
    }
    i++;
    swap(arr, i, end);
    return i;
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static String print(int[] arr) {
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
    System.out.println("After sorting, arr = " + print(quickSort(arr)));
  }
}
