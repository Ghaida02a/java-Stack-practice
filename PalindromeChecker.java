import java.util.Stack;

class PalindromeChecker {
    public static void main(String[] args) {
        PalindromeChecker stringChecker = new PalindromeChecker();

        System.out.println(stringChecker.isPalindrome("Hi")); //false
        System.out.println(stringChecker.isPalindrome("SOs")); //true
    }

    public boolean isPalindrome(String input) {
        String lowercased = input.toLowerCase();
        Stack<Character> stack = new Stack<>();

        //Push all characters of 'lowercased' onto the stack.
        for(char currentChar : lowercased.toCharArray()) {
            stack.push(currentChar);
        }

        StringBuilder reversed = new StringBuilder();
        //Pop all characters from the stack and append to 'reversed'.
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        return lowercased.equals(reversed.toString());//Compare 'lowercased' with the reversed string.
    }
}