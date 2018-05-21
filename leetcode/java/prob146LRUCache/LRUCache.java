/*
Resources: https://leetcode.com/problems/lru-cache/#/description

Problem 146: LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key
exists in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); // capacity of 2

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

import java.util.Map;
import java.util.HashMap;

public class LRUCache {

  Map<Integer, DLinkedNode> map;
  int count, capacity;
  DLinkedNode head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    count = 0;
    map = new HashMap<Integer, DLinkedNode>();
    head = new DLinkedNode(0,0);
    tail = new DLinkedNode(0, 0);
    head.nextNode = tail;
    head.prevNode = null;
    tail.prevNode = head;
    tail.nextNode = null;
  }

  // We will always put the most recently used node next to the head and
  // the least recently used node just before tail

  public int get(int key) {

    if (map.containsKey(key)) {
      DLinkedNode node = map.get(key);
      // we remove it and then insert it next to the head (since it is the most recently used)
      deleteNode(node);
      insertAtHead(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    DLinkedNode newNode = new DLinkedNode(key, value);
    if (map.containsKey(key)) {
      DLinkedNode oldNode = map.get(key);
      map.put(key, newNode); // update the map key with its new value
      deleteNode(oldNode); // remove the old node
      insertAtHead(newNode); // insert the neew node next to head.
    } else {
      map.put(key, newNode); // add it to the hash map
      if (count < capacity) { // there is still room, so we increment counter and add newNode next to head
        count++;
        insertAtHead(newNode);
      } else { // we reached capacity, so we evict the least recently used (oldest) item before inserting the new item
        DLinkedNode oldNode = tail.prevNode; // this is the oldest used node
        map.remove(oldNode.key); // remove it from hash map
        deleteNode(oldNode); // remove it from doubly linked list
        insertAtHead(newNode); // insert the new node at head
      }
    }

  }

  public void insertAtHead(DLinkedNode node) {
    node.nextNode = head.nextNode;
    head.nextNode.prevNode = node;
    node.prevNode = head;
    head.nextNode = node;
  }

  public void deleteNode(DLinkedNode node) {
    node.prevNode.nextNode = node.nextNode;
    node.nextNode.prevNode = node.prevNode;
  }

  public static class DLinkedNode {
    public int key, value;
    public DLinkedNode prevNode, nextNode;

    public DLinkedNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2); // capacity = 2

    System.out.println("Created a cache of capacity 2");
    System.out.println("cache.put(1, 1)");
    cache.put(1, 1);
    System.out.println("cache.put(2, 2)");
    cache.put(2, 2);
    System.out.println("cache.get(1) = " + cache.get(1)); // returns 1
    System.out.println("cache.put(3, 3)"); // evicts key 2
    cache.put(3, 3);
    System.out.println("cache.get(2) = " + cache.get(2)); // returns -1 (not found)
    System.out.println("cache.put(4, 4)"); // evicts key 1
    cache.put(4, 4);
    System.out.println("cache.get(1) = " + cache.get(1)); // returns -1 (not found)
    System.out.println("cache.get(3) = " + cache.get(3)); // returns 3
    System.out.println("cache.get(4) = " + cache.get(4)); // returns 4
  }
}
