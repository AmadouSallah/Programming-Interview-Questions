/*
Resources: https://leetcode.com/problems/implement-trie-prefix-tree/description/

Problem 208: Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

public class Trie {

  private TrieNode root;

  public  Trie() {
      root = new TrieNode();
  }

  /** Inserts a word into the trie.
  Complexity: O(n) runtime, where n is length of word, and O(1) space. */
  public void insert(String word) {
    TrieNode node = root;
    int n = word.length();
    for (int i = 0; i < n; i++) {
      char c = word.charAt(i);
      if (!node.containsKey(c)) {
        node.put(c, new TrieNode());
      }
      node = node.get(c);
    }
    node.setEnd();
  }

  /** Returns true if the word is in the trie, and false otherwise.
  Complexity: O(n) runtime, where n is length of word, and O(1) space. */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  /** Returns if there is any word in the trie that starts with the given prefix.
  Complexity: O(n) runtime, where n is length of word, and O(1) space. */
  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }

  /** Searches a prefix or a whole key in the trie and returns
      the node where the search ends
  Complexity: O(n) runtime, where n is length of prefix, and O(1) space. */
  private TrieNode searchPrefix(String prefix) {
    TrieNode node = root;
    int n = prefix.length();
    for (int i = 0; i < n; i++) {
      char c = prefix.charAt(i);
      if (!node.containsKey(c)) {
        return null;
      }
      node = node.get(c);
    }
    return node;
  }


  public static class TrieNode {

    private final int N = 26;
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode() {
      children = new TrieNode[N];
    }

    public boolean containsKey(char c) {
      return children[c - 'a'] != null;
    }

    public TrieNode get(char c) {
      return children[c - 'a'];
    }

    public void put(char c, TrieNode node) {
      children[c - 'a'] = node;
    }

    public boolean isEnd() {
      return isEnd;
    }

    public void setEnd() {
      isEnd = true;
    }
}

}
