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

  public static void delete(int index) {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The heap is empty!");
    }

    int parentIndex = getParent(index);

    heapArray[index] = heapArray[size-1];

    if (index == 0 || heapArray[index] < heapArray[parentIndex]) {
      bubbleDown(index, size-1);
    } else {
      bubbleUp(index);
    }

    size--;
  }

  public static void heapSort() {
    int lastIndex = size-1;
    for (int i = 0; i < lastIndex; i++) {
      swap(heapArray, 0, lastIndex-i);
      bubbleDown(0, lastIndex-i-1);
    }
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


  private static void bubbleDown(int index, int lastIndex) { // need lastIndex for heapSort() method
    int childToSwap;

    while (index <= lastIndex) {
      int leftChild = getLeftChild(index), rightChild = getRightChild(index);

      if (leftChild <= lastIndex) { // leftChild is valid
        if (rightChild > lastIndex) { // rightChild is invalid
          childToSwap = leftChild; // since leftChild exists and rightChild doesn't exist
        } else { // rightchild exists
          // since both leftChild and rightChild exists, childToSwap is the larger of the 2
          childToSwap = (heapArray[leftChild] > heapArray[rightChild]) ? leftChild : rightChild;
        }

        if (heapArray[index] < heapArray[childToSwap]) {
          swap(heapArray, index, childToSwap);
        } else {
          break;
        }

        index = childToSwap;
      }

      else { // leftChild >= size, so it doesn't exists, therefore rightChild cannot exist also
        break;
      }
    }
  }

  private static void swap(int[] array, int i, int j) {
    if (i == j) return;
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
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
    maxHeap.insert(30);
    maxHeap.insert(2);

    System.out.println(printHeap());

    System.out.println("\nDeleting the top element (at index 0):");
    maxHeap.delete(0);
    System.out.println(printHeap());

    System.out.println("\nDeleting the last element at index " + (size-1));
    maxHeap.delete(size-1);
    System.out.println(printHeap());

    System.out.println("\nDeleting the middle element at index " + size/2);
    maxHeap.delete(size/2);
    System.out.println(printHeap());

    System.out.println("\nSorting the heap array using heapSort()");
    maxHeap.heapSort();
    System.out.println(printHeap());
  }

}
