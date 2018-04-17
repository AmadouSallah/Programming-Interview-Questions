// Implementation of a Trie with insert, search, startsWith, and delete

import java.util.Map;
import java.util.HashMap;

public class Trie {

  public static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
      children = new HashMap<>();
      isEnd = false;
    }
  }
}
