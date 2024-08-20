package Stack;

import java.util.*;

public class Solution_0820 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 至少含有根目录
        stack.push("/");
        String[] pathArr = split(path);
        int len = pathArr.length;
        for (int i = 0; i < len; i++) {
            if (pathArr[i].equals("..")) {
                stack.pop();
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!pathArr[i].equals(".") && !pathArr[i].equals("")) {
                stack.push(pathArr[i]);
                stack.push("/");
            }
            // 需要提前返回
            if (stack.empty()) {
                stack.push("/");
            }
        }
        String result = stackToString(stack);
        if (result.length() > 1 && result.charAt(result.length() - 1) == '/') {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * @param s 原串
     * @return 以'/'切割后的字符串数组
     */
    public String[] split(String s) {
        return s.split("/");
    }

    public String stackToString(Stack<String> stack) {
        List<String> list = new ArrayList<>(stack.size());
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return String.join("", list);
    }

    public static void main(String[] args) {
        Solution_0820 solution = new Solution_0820();
        String s = "/../";
        for (String str : solution.split(s)) {
            System.out.print(str);
            System.out.print(",");
        }
        System.out.println("");
        String res = solution.simplifyPath(s);
        System.out.println(res);
    }
}
