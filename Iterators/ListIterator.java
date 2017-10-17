import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class ListIterator {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    // System.out.println("list = " + list);

    // Using iterator to display the contents of list
    Iterator itr = list.iterator();

    System.out.print("list = ");

    while (itr.hasNext()) {
      Object elt = itr.next();
      System.out.print (elt + " ");
    }
    System.out.println();

    // //Modify objects being iterated:
    // ListIterator lItr = list.listIterator();
    // while (lItr.hasNext()) {
    //   Object elt = lItr.next();
    //   lItr.set(elt + "+");
    // }
    // //System.out.println("After modification, list = " + list);
    // System.out.print("After modification, list =  ");
    // itr = list.iterator();
    // while(itr.hasNext()) {
    //   Object elt = itr.next();
    //   System.out.print(elt + " ");
    // }
    // System.out.println();
    //
    // System.out.print("Modified list backward = ");
    // while (lItr.hasPrevious()) {
    //   Object elt = lItr.previous();
    //   System.out.print(elt + " ");
    // }
    // System.out.println();
  }
}

// Resources: https://www.tutorialspoint.com/java/java_using_iterator.htm
