import java.util.Stack;

class BracketChecker {
    public static void main(String[] args) {
        BracketChecker checker = new BracketChecker();
        System.out.println(checker.isBalancedRefactored("([{}])")); // true
        System.out.println(checker.isBalancedRefactored("([)]"));   // false
        System.out.println(checker.isBalancedRefactored("((("));    // false
    }

    public boolean isBalancedRefactored(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else { // if c == ')' || c == '}' || c == ']'
                if(stack.isEmpty()){
                    return false;
                }
                char topBracket = stack.pop();
                if ((c == ')' && topBracket != '(') || (c == '}' && topBracket != '{') || (c == ']' && topBracket != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}