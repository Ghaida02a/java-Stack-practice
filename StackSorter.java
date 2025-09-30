import java.util.Stack;

class StackSorter {
    public static void main(String[] args) {
        StackSorter sorter = new StackSorter();
        Stack<Integer> stack = new Stack<>();

        stack.push(50);
        stack.push(20);
        stack.push(110);
        stack.push(10);

        System.out.println("Original stack: " + stack);

        sorter.sortStack(stack);

        System.out.println("Sorted stack (smallest on top): " + stack);
    }

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!stack.isEmpty()) {
            int lastElement = stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > lastElement) {
                stack.push(sortedStack.pop());
            }

            sortedStack.push(lastElement);
        }

        while (!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
        }
    }
}