import java.util.Arrays;

public class AreAnagrams {

  public static boolean areAnagrams(String s1, String s2) {
    String s11 = s1.replaceAll("\\s+", "");
    String s22 = s2.replaceAll("\\s+", "");

    if (s11.length() != s22.length())
      return false;

    char[] arr1 = s11.toLowerCase().toCharArray();
    char[] arr2 = s22.toLowerCase().toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int len = arr1.length;

    for (int i = 0; i < len; i++) {
      if (arr1[i] != arr2[i])
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(areAnagrams("Keep", "Pe  ek"));
    System.out.println(areAnagrams("SiLent  Cat", "Listen AcT"));
  }
}