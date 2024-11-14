import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    // Problem 1
    System.out.println("Input word: ");
    String word = sc.nextLine();
    System.out.println("Input target: ");
    String target = sc.nextLine();
    System.out.println("The substring " + target + " appears " + countSub(word, target) + " times");

    // Problem 2
    System.out.println("Input word: ");
    word = sc.nextLine();
    System.out.println("Input target: ");
    target = sc.nextLine();
    System.out.println("The substring " + target + " is properly contained " + countProperContains(word, target) + " times");

    // Problem 3
    System.out.println("Input word: ");
    word = sc.nextLine();
    System.out.println("Input target: ");
    target = sc.nextLine();
    System.out.println(deleteSub(word, target));
  }

  public static int countSub(String word, String target)
  {
    int count = 0;
    for (int i = 0; i < word.length() - (target.length() - 1); i++) {
     String sub = word.substring(i, i + target.length());
      if (sub.equals(target)) {
        count++;
      }
    }
    return count;
  }

  public static int countProperContains(String word, String target)
  {
    int count = 0;
    int N = target.length();
    for (int i = 0; i < word.length() - (N-1); i++){
      String L = word.substring(i, i+N);
      if (L.equals(target)) {
        int beginOfTarget = i;
        int endOfTarget = i+target.length();
        boolean spaceBefore = (beginOfTarget == 0 || word.substring(beginOfTarget-1, beginOfTarget).equals(" "));
        boolean spaceAfter = (beginOfTarget == word.length() || word.substring(endOfTarget, endOfTarget+1).equals(" "));
        if (spaceBefore && spaceAfter){
          count++;
        }
      }
    }
    
    return count;
  }

  public static String deleteSub(String word, String target)
  {
    while (word.indexOf(target) != -1) {
      word = word.substring(0, word.indexOf(target)) + word.substring(word.indexOf(target) + target.length());
    }
    return word;
  }
}
