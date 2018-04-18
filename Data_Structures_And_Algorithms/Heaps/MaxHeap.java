public class MaxHeap {
  private int size;
  private int[] array;

  public MaxHeap(int capacity) {
    array = new int[capacity];
  }

  public int getLeftChild(int index) {
    return 2 * index + 1;
  }
}
