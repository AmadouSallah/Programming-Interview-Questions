public class MaxHeap {
  private int size;
  private int[] array;

  public MaxHeap(int capacity) {
    array = new int[capacity];
  }

  public int getLeftChild(int index) {
    return 2 * index + 1;
  }

  public int getRightChild(int index) {
    return 2 * index + 2;
  }

  public int getParent(int index) {
    return (index - 1) / 2;
  }

  public boolean isFull() {
    return size == array.length;
  }

  public int size() {
    return array.length;
  }
}
