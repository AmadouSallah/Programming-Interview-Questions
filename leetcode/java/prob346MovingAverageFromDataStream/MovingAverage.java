/*
Problem 346: Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average
of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
import java.util.Queue;
import java.util.LinkedList;

public class MovingAverage {
  private int size, count, sum;
  Queue<Integer> queue = new LinkedList<Integer>();

  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    if (count == size)
      sum -= queue.poll();
    else
      count++;

    sum += val;
    queue.add(val);

    return ((double) sum) / ((double) count);
  }
}