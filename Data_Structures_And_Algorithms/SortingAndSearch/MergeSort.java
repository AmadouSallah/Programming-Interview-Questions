public class MergeSort {

  public static int[] mergeSort(int[] arr) {
    int n = arr.length;
    if (n < 2) return arr;

    int mid = n/2;
    int[] leftArray = new int[mid], rightArray = new int[n - mid];
    int n1 = leftArray.length, n2 = rightArray.length;
    for (int i = 0; i < n1; i++) {
      leftArray[i] = arr[i];
    }
    // same as System.arraycopy(arr, 0, leftArray, 0, n1);

    for (int i = 0; i < n2; i++) {
      rightArray[i] = arr[i + mid];
    }
    // sane as System.arraycopy(arr, mid, rightArray, 0, n2);
    return merge(mergeSort(leftArray), mergeSort(rightArray));
  }

  public static int[] merge(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length, n = n1 + n2;
    int[] result = new int[n];
    int i = 0, j = 0;

    for (int k = 0; k < n; k++) {
      if (i >= n1) {
        result[k] = arr2[j++];
      } else if (j >= n2) {
        result[k] = arr1[i++];
      } else if (arr1[i] < arr2[j]) {
        result[k] = arr1[i++];
      } else {
        result[k] = arr2[j++];
      }
    }
    return result;
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
    System.out.println("After sorting, arr = " + print(mergeSort(arr)));
  }
}

// Resources: https://algs4.cs.princeton.edu/14analysis/Mergesort.java.html
