import java.util.Stack;

class TextEditor {
    private StringBuilder content;
    private Stack<String> history;

    public TextEditor() {
        this.content = new StringBuilder();
        this.history = new Stack<>();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type(" World");
        System.out.println(editor.getContent()); // Hello World

        editor.undo();
        System.out.println(editor.getContent()); // Hello
    }
    /**
     * TO-DO: Appends text to the current content.
     * Before changing the content, save the current state to the history stack.
     \*
     * @param text The text to append.
     */
    public void type(String text) {
        //Push the current content to history
        history.push(content.toString());
        this.content.append(text);
    }

    /**
     * TO-DO: Reverts the content to its state before the last 'type' operation.
     * If there is no history, the content should not change.
     */
    public void undo() {
        // If history is not empty, pop and restore the content.
        if (!history.isEmpty()){
            String prev = history.pop();
            content.setLength(0);       // clear the current content
            content.append(prev);
        }
    }

    public String getContent() {
        return content.toString();
    }
}