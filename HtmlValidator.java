import java.util.Stack;

class HtmlValidator {
    public static void main(String[] args) {
        HtmlValidator validator = new HtmlValidator();

        String[] tags1 = {"<html>", "<body>", "<p>", "</p>", "</body>", "</html>"};
        String[] tags2 = {"<div>", "<span>", "</span>", "</div>"};
        String[] tags3 = {"<a>", "<b>", "</b>"}; // Missing </a>

        System.out.println(validator.isWellFormed(tags1)); // true
        System.out.println(validator.isWellFormed(tags2)); // true
        System.out.println(validator.isWellFormed(tags3)); // false
    }

    public boolean isWellFormed(String[] tags) {
        Stack<String> tagStack = new Stack<>();

        for (String tag : tags) {
            if (tag.startsWith("</")) { //closing tag
                String tagName = tag.substring(2, tag.length() - 1);
                if(tagStack.isEmpty()){
                    return false;
                }
                String openingTag = tagStack.pop();
                if(!openingTag.equals(tagName)){
                    return false;
                }

            }
            else { //opening tag
                String tagName = tag.substring(1 , tag.length() - 1);
                tagStack.push(tagName);
            }
        }

        return tagStack.isEmpty();
    }
}