import java.util.Stack;

class StackManipulator {
    public static void main(String[] args) {
        StackManipulator manipulator = new StackManipulator();
        Stack<Integer> stack = new Stack<>();

        //add elements to stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original stack: " + stack);

        // Remove bottom element from stack
        Integer bottomOfStack = manipulator.removeBottomElement(stack);

        System.out.println("Removed bottomOfStack element: " + bottomOfStack);
        System.out.println("Stack after removal: " + stack);
    }

    public Integer removeBottomElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return null;
        }

        Stack<Integer> tempStack = new Stack<>();
        //move elements from original stack to temStack
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }

        Integer bottomElement = tempStack.pop(); //pop last element from temStack
        //move elements from temStack to original Stack
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }

        return bottomElement;
    }
}