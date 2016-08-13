/*
Problem 380: Insert Delete GetRandom O(1)

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements.
Each element must have the same probability of being returned.

Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();

*/

/*
PSEUDOCODE:

We initialize a hash and a list. The hash will have as key a value in the list
and the corresponding value of the key will be the index of that value in the list.
Example, if list = [3, 2, 1, 5], then hash = {3=>0, 2=>1, 1=>2. 5=>3}.
Therefore, the hash will allow us to know the location of the values in the list

The method insert(int val):
It takes as input a value, val, to be added to the list and it returns a boolean.
If val is already in the list (i.e hash contains val), we return false.
Otherwise:
  1. We add the key 'val' to the hash with corresponding value the size of the list.
  (This will ensure that the value of any key added to the hash will correspond
  to its location in the list).
  2. We add val to the end of the list (at list.size()).
  3. We then return true


The method remove(int val):
This method takes an integer, val, and returns a boolean.
If val is not in the hash, meaning that it is not in the list, we return false
since there is nothing to be removed.
Otherwise:
  1. Let indexOfVal be the index of val in the list (the value of val in the hash) and
  let lastElement be the last element of the list. We remove val from the hash and
  lastElement from the list.
  2. If lastElement is the same as val, we are done; just return true.
  Otherwise, we put lastElement at index indexOfVal in the list. We then update
  the hash to have key-value pair lastElement=>indexOfVal
  3. we return true

The method getRandom();
This method returns a random value in the list.
We get a random number between 0 and list.size()-1.
We then return the list value located at the index corresponding to the above random number.

*/

import java.util.*;

public class RandomizedSet {

  static List<Integer> list;
  static Map<Integer, Integer> hashMap;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    list = new ArrayList<Integer>();
    hashMap = new HashMap<Integer, Integer>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {

    if (hashMap.containsKey(val))
        return false;

    //
    hashMap.put(val, list.size());
    list.add(val);

    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {

    if (!hashMap.containsKey(val))
        return false;

    // val is in our list
    int indexOfVal = hashMap.remove(val);
    int lastElement = list.remove(list.size() - 1);

    if (lastElement != val) {
      list.set(indexOfVal, lastElement);
      hashMap.put(lastElement, indexOfVal);
    }
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random random = new Random(); // choosing a different seed each time
    int randomIndex = random.nextInt(list.size()); // random number between 0 and list.size()-1
    return list.get(randomIndex);
  }

  // Returns index of element if it is present, otherwise null
  public int search(int val) {
    if (!hashMap.containsKey(val))
      return -1;

    return hashMap.get(val);
  }

  public static void main(String[] args) {
    RandomizedSet obj = new RandomizedSet();
    obj.insert(1);
    obj.insert(3);
    obj.insert(2);
    obj.insert(1);
    obj.insert(4);
    System.out.println("After adding 1, 2, 3, 1, and 4 to the list: list = " + list + ", hash = " + hashMap);
    obj.remove(3);

    System.out.println("After removing 3, list = " + list + ", hash = " + hashMap);

    System.out.println("Getting a random value: " + obj.getRandom());
    System.out.println("Getting a random value: " + obj.getRandom());
    System.out.println("Getting a random value: " + obj.getRandom());

    System.out.println("Searching for 3: " + obj.search(3));
    System.out.println("Searching for 4: " + obj.search(4));
  }
}