public class Stack {
    private final String input = "(((())))))))()()()))(((()))((()";
    char open = 0x0028;
    char close = 0x0029;


    public boolean check(String input) {
        java.util.Stack<Character> eStack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            if (c == open) {
                eStack.push(c);
            } else if (c == close) {
                if (eStack.empty()) {
                    return false;
                }
                eStack.pop();
            }
        }
        return eStack.empty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.check(stack.input));
    }
}
