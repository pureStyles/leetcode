import java.util.Stack;

public class Solution_0819 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                // 左侧，入栈
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                Character bracket = stack.peek();
                if (bracket == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                Character bracket = stack.peek();
                if (bracket == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.empty()) {
                    return false;
                }
                Character bracket = stack.peek();
                if (bracket == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_0819 solution = new Solution_0819();
        String s = "(]";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}
