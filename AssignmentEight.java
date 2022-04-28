import java.util.Stack;

public class AssignmentEight {
    public static void main(String[] args) {
        System.out.println(isPatternCorrect("((("));
        System.out.println(isPatternCorrect("{}"));
        System.out.println(isPatternCorrect("(()){}[]"));
        System.out.println(isPatternCorrect("{({})}"));
    }

    private static boolean isPatternCorrect(String pattern) {
        char firstChar = '(';
        char secondChar = '{';
        char thirdChar = '[';
        char reversedFirst = ')';
        char reveredSecond = '}';
        char reversedThird = ']';

        Stack<Character> myPattern = new Stack<>();
        char[] charsArray = pattern.toCharArray();

        if (pattern.length() % 2 != 0) {
            return false;
        }

        for (char i : charsArray) {
            if (i == firstChar || i == secondChar || i == thirdChar) {
                myPattern.push(i);
            } else if (i == reversedFirst || i == reveredSecond || i == reversedThird) {
                char poppedChar = myPattern.pop();
                //აქ თვითონ სიმპლიფაიო თორემ მე ასე არ მეწერა :დდ
                return poppedChar == firstChar && i == reversedFirst ||
                        poppedChar == secondChar && i == reveredSecond ||
                        poppedChar == thirdChar && i == reversedThird;
            }
        }

        //აქაც სიმპლიფაიო..
        return myPattern.isEmpty();
    }
}
