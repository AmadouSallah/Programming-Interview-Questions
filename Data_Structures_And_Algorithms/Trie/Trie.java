// Implementation of a Trie with insert, search, startsWith, wordsStartingWith, and delete

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Trie {

  public static TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  // Complexity: O(n) runtime and O(1) space, where n is length of the input word,
  public static void insert(String word) {
    TrieNode current = root;
    int n = word.length();
    for (int i = 0; i < n; i++) {
      char c = word.charAt(i);
      if (!current.children.containsKey(c)) {
        current.children.put(c, new TrieNode());
      }
      current = current.children.get(c);
    }
    current.isEnd = true;
  }

  /* search: returns true if the input word is in the trie, and false otherwise.
    Complexity: O(n) runtime and O(1) space, where n is length of input word. */
  public static boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd;
  }

  /* startsWith: Returns true if there is any word in the trie that starts with the given prefix, false otherwise
    Complexity: O(n) runtime and O(1) space, where n is length of input prefix. */
  public static boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }

  // wordsStartingWith: returns a list of all words that starts with input prefix
  public static List<String> wordsStartingWith(String prefix) {
    List<String> result = new ArrayList<>();
    TrieNode node = searchPrefix(prefix);
    wordsStartingWithHelper(prefix, result, node);
    return result;
  }

  private static void wordsStartingWithHelper(String prefix, List<String> result, TrieNode node) {
    if (node == null) {
      return;
    }
    if (node.isEnd) {
      result.add(prefix);
      return;
    }

    for (char c : node.children.keySet()) {
      TrieNode newNode = node.children.get(c);
      wordsStartingWithHelper(prefix + c, result, newNode);
    }
  }

  // searchPrefix: Searches a prefix or a whole key in trie and returns the node where the search ends
  // Complexity: O(n) runtime and O(1) space, where n is  the length of input prefix
  private static TrieNode searchPrefix(String prefix) {
    TrieNode current = root;
    int n = prefix.length();
    for (int i = 0; i < n; i++) {
      char c = prefix.charAt(i);
      if (!current.children.containsKey(c)) {
        return null;
      }
      current = current.children.get(c);
    }
    return current;
  }

  private static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
      children = new HashMap<>();
      isEnd = false;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    System.out.println("Inserting \"abc\" in trie");
    trie.insert("abc");
    System.out.println("Inserting \"abd\" in trie");
    trie.insert("abd");
    System.out.println("Inserting \"cdef\" in trie");
    trie.insert("cdef");

    System.out.println("wordsStartingWith(\"ab\") = " + wordsStartingWith("ab"));
  }
}
