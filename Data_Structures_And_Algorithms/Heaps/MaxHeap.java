public class MaxHeap {
  private static int size;
  private static int[] heapArray;

  public MaxHeap(int capacity) {
    heapArray = new int[capacity];
  }

  public static void insert(int value) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("The heap is full!");
    }
    heapArray[size] = value;
    bubbleUp(size);
    size++;
  }

  private static void bubbleUp(int index) {
    int newValue = heapArray[index], parentIndex = getParent(index);

    while(index > 0 && newValue > heapArray[parentIndex]) {
      heapArray[index] = heapArray[parentIndex];
      index = parentIndex;
      parentIndex = getParent(index);
    }

    heapArray[index] = newValue;
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
    return size == heapArray.length;
  }

  public static boolean isEmpty() {
    return size == 0;
  }

  public static int size() {
    return size;
  }

  public static String printHeap() {
    String result = "[";

    for (int i = 0; i < size-1; i++) {
      result += heapArray[i] + ", ";
    }
    if (size > 0) {
      result += heapArray[size-1];
    }
    result += "]";
    return result;
  }

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(5);
    maxHeap.insert(10);
    maxHeap.insert(1);
    maxHeap.insert(25);
    maxHeap.insert(-1);
    System.out.println(printHeap());
  }

}
