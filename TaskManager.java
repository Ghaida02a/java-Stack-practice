import java.util.Stack;

class TaskManager {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Stack<String> tasks = new Stack<>();

        tasks.push("Task A"); //first element
        tasks.push("Task B"); //second element
        tasks.push("Task C"); //third element (top)

        // Expected: "Task A -> Task B -> Task C"
        System.out.println(manager.getTaskSequence(tasks));

        System.out.println("Stack after method (top to bottom): " + tasks);
    }

    public String getTaskSequence(Stack<String> tasks) {
        if (tasks.isEmpty()) {
            return "";
        }

        Stack<String> reversedStack = new Stack<>();
        // Move all elements from 'tasks' to 'reversedStack'.
        while (!tasks.isEmpty()) {
            reversedStack.push(tasks.pop());
        }

        StringBuilder sequence = new StringBuilder();
        // Pop from 'reversedStack' to build the string.
        String task = null;
        while (!reversedStack.isEmpty()) {
            task = reversedStack.pop();
            sequence.append(task);
            // Remember to add " -> " between tasks but not at the end.
            if (!reversedStack.isEmpty()) {
                sequence.append(" -> ");
            }
            // Restore the original 'tasks' stack
            tasks.push(task);
        }
        return sequence.toString();
    }
}