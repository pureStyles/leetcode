package Stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> list = new ArrayList<>(30000);
    List<Integer> minList = new ArrayList<>(30000);

    public MinStack() {
        // 栈操作；
        // 先初始化为最大值；
        minList.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        list.add(val);
        int minVal = Math.min(val, minList.get(minList.size() - 1));
        minList.add(minVal);
    }

    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);

        minStack.pop();
        int res = minStack.top();
        System.out.println(res);

        int sec = minStack.getMin();
        System.out.println(sec);
    }
}
