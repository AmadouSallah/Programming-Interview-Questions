/*
Problem 251: Flatten 2D Vector

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[ [1,2], [3], [4,5,6] ]
By calling next repeatedly until hasNext returns false, the order of elements returned
by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

*/

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

  private int row, col;
  private List<List<Integer>> vec2d;

  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;
    this.row = 0;
    this.col = 0;
  }

  @Override
  public Integer next() {
    List<Integer> currentRowList = vec2d.get(row);
    int elt = currentRowList.get(col);
    col++;

    return elt;
  }

  @Override
  public boolean hasNext() {
    while (row < vec2d.size()) {
      List<Integer> currentRowList = vec2d.get(row);
      int currentRowSize = currentRowList.size();

      if (col < currentRowSize) {
        return true;
      }
      else {
        row++;
        col = 0;
      }
    }
    return false;
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
