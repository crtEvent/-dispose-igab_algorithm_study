package doit.ch03.sec5_stack_queue.boj4949;

import java.io.*;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        Stack<Character> stack = new Stack<>();

        while (!temp.equals(".")) {

            capture:
            for (char c : temp.toCharArray()) {
                switch(c) {
                    case '(': case '[' :
                        stack.push(c);
                        break;
                    case ')' :
                        if (!stack.isEmpty() && stack.peek()=='(') stack.pop();
                        else break capture;
                        break;
                    case ']' :
                        if (!stack.isEmpty() && stack.peek()=='[') stack.pop();
                        else break capture;
                        break;
                    case '.' :
                        break capture;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            temp = br.readLine();
            stack = new Stack<>();
        }
    }
}
