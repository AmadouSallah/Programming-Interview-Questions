public class MaxHeap {
  private static int size;
  private static int[] array;

  public MaxHeap(int capacity) {
    array = new int[capacity];
  }

  public static int getLeftChild(int index) {
    return 2 * index + 1;
  }

  public static int getRightChild(int index) {
    return 2 * index + 2;
  }

  public static int getParent(int index) {
    return (index - 1) / 2;
  }

  public static boolean isFull() {
    return size == array.length;
  }

  public static int size() {
    return size;
  }

  public static String printHeap() {
    String result = "[";

    for (int i = 0; i < size; i++) {
      result += array[i] + ", ";
    }
    if (size > 0) {
      result += array[size-1];
    }
    result += "]";
    return result;
  }

  public static void main(String[] args) {
    System.out.println(printHeap());
  }

}
