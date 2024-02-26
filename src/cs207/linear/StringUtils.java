package cs207.linear;
import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Shibam Mukhopadhyay
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  static char OPEN_BRACKETS[] = {'(', '{', '[', '<'}; 
  static char CLOSE_BRACKETS[] = {')', '}', ']', '>'}; 
 
 // Check if val is in array of characters and returns index. If not contained returns -1.
 public static int indexOf(char[] arr, char val) {
  for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
          return i;
      }
  }
  return -1;
 }// indexOf(char[], char)
 
 
  /*
 * Determine whether the parens match in string.
 */
public static boolean checkMatching(String str) throws Exception {
  Stack<Character> parens = new LinkedStack<Character>();
  for (int i = 0; i < str.length(); i++) {
      char currChar = str.charAt(i);
      // Check if currChar is an open bracket
      if (indexOf(OPEN_BRACKETS, currChar) != -1) {
          try {
              parens.put(currChar);
          } catch (Exception e) {
              System.err.println("Could not put to stack");
          }
          continue;
      } 
      // Check if currChar is close bracket
      if (indexOf(CLOSE_BRACKETS, currChar) != -1) {
          // if paren is emptry then return error since mismatch of brackets
          if (parens.isEmpty()) {
              System.err.println("Closed Bracket mismatched - 1");
              return false;
          } // if()
          // if indexes are equal, the parens are same and we can pop!
          if (indexOf(CLOSE_BRACKETS, currChar) == indexOf(OPEN_BRACKETS, parens.peek())) {
              parens.pop();
          } else {
              // else brackets are there but not same type leading to mismatch.
              System.err.println("Closed Bracket mismatched - 2");
              return false;
          } 
      } 
  }// for
  // if array is not empty then throw error since there is an open bracket but no close
  if (parens.isEmpty()) {
      return true;
  } 
  System.err.println("Open Bracket is mismatched");
  return false;
} // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils