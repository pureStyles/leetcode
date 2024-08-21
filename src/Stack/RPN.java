package Stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (isNumeric(tokens[i])) {
                // 遇到数字，则入栈
                stack.push(tokens[i]);
            } else if (tokens[i].equals("-")) {
                // del
                String right = stack.pop();
                String left = stack.pop();
                int result = Integer.parseInt(left) - Integer.parseInt(right);
                System.out.println(result);
                stack.push(Integer.toString(result));
            } else if (tokens[i].equals("+")) {
                // add
                String right = stack.pop();
                String left = stack.pop();
                int result = Integer.parseInt(left) + Integer.parseInt(right);
                stack.push(String.valueOf(result));
            } else if (tokens[i].equals("*")) {
                // multiple
                String right = stack.pop();
                String left = stack.pop();
                int result = Integer.parseInt(left) * Integer.parseInt(right);
                stack.push(String.valueOf(result));
            } else if (tokens[i].equals("/")) {
                // divide
                String right = stack.pop();
                String left = stack.pop();
                int result = Integer.parseInt(left) / Integer.parseInt(right);
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.peek());
        return Integer.parseInt(stack.pop());
    }

    public boolean isNumeric(String s) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        return pattern.matcher(s).matches();
    }

    public static void main(String[] args) {
        RPN rpn = new RPN();
        String[] tokens = new String[]{"4", "3", "-"};
        int result = rpn.evalRPN(tokens);
        System.out.println(result);
    }
}
