public class InsertionSort {

  // O(n^2) runtime and O(1) space complexities.
   // Stable sort
   public static int[] insertionSort(int[] arr) {
     int n = arr.length;
     for (int i = 1; i < n; i++) { // i is the first unsorted index
       int currentElement = arr[i], j = i;

       while (j > 0 && currentElement < arr[j-1]) {
         arr[j] = arr[j-1];
         j--;
       }

       arr[j] = currentElement;
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
    int[] sortedArr = insertionSort(arr);
    System.out.println("After sorting, arr = " + print(sortedArr));
  }
}
