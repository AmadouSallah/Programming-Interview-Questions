/*
Given a list that contains a nested lists, write a funtion to flatten it.

Examples:

input = [1, [2, 3], 4]
output = [1, 2, 3, 4]

input = [1, [2, 3], 4, [5, 6, 7]]
output = [1, 2, 3, 4, 5, 6, 7]

input = [[1], [2, [3, [4]]], 5]
result = [1, 2, 3, 4, 5]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;

public class FlattenList {

  // Recursive solution
  public static List<Integer> flattenRecursive(List<?> list) { // or List<Objec>
    List<Integer> result = new ArrayList<>();
    flattenHelper(list, result);
    return result;
  }

  public static void flattenHelper(List<?> list, List<Integer> result) {

    Iterator itr = list.iterator();

    while (itr.hasNext()) {
      Object obj = itr.next();
      if (obj instanceof Integer) { // if obj is an int, add it to result
        result.add( (Integer) obj);
      } else { // otherwise, call flattenRecursive on it since it is a list
        flattenHelper( (List<?>) obj, result);
      }
    }
  }

  public static List<Integer> flattenIterative(List<?> list) {
    List<Object> tempList = null;
    List newList = new ArrayList<>();
    newList.addAll(list);

    ListIterator itr = newList.listIterator();
    while (itr.hasNext()) {
      Object obj = itr.next();

      if (obj instanceof List) { // if obj is a list, then
        tempList = (List) obj; // we save it to tempList
        itr.remove(); // we remove it from newList

        // Now add each item of tempList, i.e of obj, to newList,
        // (this adds at the same position where obj was removed)
        for (Object o : tempList) {
          itr.add(o);
        }

        // Reset the iterator, itr
        itr = newList.listIterator();
      }
    }

    return newList;
  }

  public static void main(String[] args) {
    // list1 = [1, [2, 3], 4]
    // list2 = [1, [2, 3], 4, [5, 6, 7]];
    // list3 = [[1], [2, [3, [4]]], 5]
    List<?> list1 = Arrays.asList(1, Arrays.asList(2, 3), 4);
    List<Object> list2 = Arrays.asList(1, Arrays.asList(2, 3), 4, Arrays.asList(5, 6, 7));
    List<Object> list3 = Arrays.asList( Arrays.asList(1), Arrays.asList(2, Arrays.asList(3, Arrays.asList(4))), 5 );

    System.out.println("flattenRecursive([1, [2, 3], 4]) = " + flattenRecursive(list1));
    System.out.println("flattenIterative([1, [2, 3], 4]) = " + flattenIterative(list1));

    System.out.println("\nflattenRecursive([1, [2, 3], 4, [5, 6, 7]]) = " + flattenRecursive(list2));
    System.out.println("flattenIterative([1, [2, 3], 4, [5, 6, 7]]) = " + flattenIterative(list2));

    System.out.println("\nflattenRecursive([[1], [2, [3, [4]]], 5]) = " + flattenRecursive(list3));
    System.out.println("flattenIterative([[1], [2, [3, [4]]], 5]) = " + flattenIterative(list3));
  }
}

/*
Resources:
https://evanhoffman.com/2010/04/17/code-to-flatten-a-list-in-java-with-and-without-recursion/
https://gist.github.com/seanzhu/11167427
*/
