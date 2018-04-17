// Implementation of a Trie with insert, search, startsWith, and delete

import java.util.Map;
import java.util.HashMap;

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

  public static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
      children = new HashMap<>();
      isEnd = false;
    }
  }
}
