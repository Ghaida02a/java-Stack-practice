import java.util.Stack;

class PathSimplifier {
    public static void main(String[] args) {
        PathSimplifier simplifier = new PathSimplifier();

        System.out.println(simplifier.simplifyPath("/a/./b/../../c/")); // /c
        System.out.println(simplifier.simplifyPath("/../"));             // /
        System.out.println(simplifier.simplifyPath("/home//foo/"));      // /home/foo
    }
    /**
     * TO-DO: Simplify a Unix-style file path.
     * For example, "/a/./b/../../c/" should become "/c".
     * And "/../" should become "/".
     \*
     * @param path The absolute path string.
     * @return The simplified canonical path.
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        // Your code here:
        // Iterate through the 'components'.
        // Use if/else if to handle "..", ".", and regular directory names.
        for(String c : components){
            if(c.equals(".") || c.isEmpty()){

            }
            else if (c.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                // Push valid directory name
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        // Your code here:
        // Use a StringBuilder to join the elements in the stack
        // to form the final path string (e.g., "/dir1/dir2").

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}