import java.util.Stack;

public class AssignmentEight {
    public static void main(String[] args) {
//        System.out.println(isPatternCorrect("[()}"));
//        System.out.println(isPatternCorrect("[()]"));
//        System.out.println(isPatternCorrect("(({}))[]"));
//        System.out.println(isPatternCorrect("())"));
//        System.out.println(isPatternCorrect("((("));
//        System.out.println(isPatternCorrect("{}{}[]()"));
//        System.out.println(isPatternCorrect("))"));
//        System.out.println(isPatternCorrect("{)"));
        System.out.println(isPatternCorrect("{}]"));
        System.out.println(isPatternCorrect(""));

        //calling the second task
//        Queue myQueueObj = new Queue();
//        myQueueObj.push(10);
//        myQueueObj.peek();
//        myQueueObj.pop();
//        myQueueObj.size();

    }

    private static boolean isPatternCorrect(String pattern) {
        Stack<Character> myPattern = new Stack<>();
        char[] charsArray = pattern.toCharArray();

        if (pattern.length() == 0) {
            return true;
        } else if (pattern.length() % 2 != 0) {
            return false;
        } else if (charsArray[0] == ')' || charsArray[0] == '}' || charsArray[0] == ']') {
            return false;
        }

        for (char i : charsArray) {
            if (i == '(' || i == '{' || i == '[') {
                myPattern.push(i);
            } else if (i == ')' || i == '}' || i == ']') {
                char poppedChar = myPattern.pop();
                if (poppedChar == '(' && i != ')' ||
                        poppedChar == '{' && i != '}' ||
                        poppedChar == '[' && i != ']') {
                    return false;
                }
            }
        }
        return myPattern.isEmpty();
    }
}
