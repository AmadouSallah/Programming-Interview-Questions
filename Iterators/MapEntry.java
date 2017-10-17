import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class MapEntry {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    map.put(4, "four");

    // Getting a set of the entries
    Set set = map.entrySet();
    System.out.println("Entry set = " + set); // [1=one, 2=two, 3=three, 4=four]

    // Get an iterator
    Iterator itr = set.iterator();

    // Displaying elements
    while (itr.hasNext()) {
      Map.Entry mapEntry = (Map.Entry) itr.next();
      System.out.print(mapEntry.getKey() + ": ");
      System.out.println(mapEntry.getValue());
    }
  }
}

// Resources: https://www.tutorialspoint.com/java/java_mapentry_interface.htm
