/*
Problem 28: Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class StrStr {

  public static int strStr(String haystack, String needle) {
    int n1 = haystack.length(), n2 = needle.length();
    if (n2 == 0) return 0;
    if (n1 < n2) return -1;
    for (int i = 0; i < (n1-n2+1); i++) {
      for (int j = 0; j < n2; j++) {
        if (needle.charAt(j) != haystack.charAt(i+j))
          break;

        if (j == (n2-1))
          return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("strStr(\"\", \"\") = " + strStr("", ""));
    System.out.println("strStr(\"hello\", \"\") = " + strStr("hello", ""));
    System.out.println("strStr(\"hello\", \"l\") = " + strStr("hello", "l"));
    System.out.println("strStr(\"hello\", \"o\") = " + strStr("hello", "o"));
    System.out.println("strStr(\"mississippi\", \"issi\") = " + strStr("mississippi", "issi"));
    System.out.println("strStr(\"hello\", \"hi\") = " + strStr("hello", "hi"));

  }
}