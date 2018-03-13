/*
Leetcode Problem 49. Group Anagrams
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class GroupAnagrams {
  // O(n*klog(k)) runtime where k is the lenght of the longest string in input strs
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if (strs == null || strs.length == 0) return result;

    Map<String, List> map = new HashMap<>();

    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = String.valueOf(arr);

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }
    for (String key : map.keySet()) {
      result.add(map.get(key));
    }
    return result;

  }

  public static void main(String[] args) {
    String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println("groupAnagrams([\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]) = " + groupAnagrams(input));
  }
}
