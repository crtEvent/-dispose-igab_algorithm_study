package 추가문제풀이.스택_큐.boj4949_균형잡힌_세상;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = null;

        while (!".".equals(s = br.readLine())) {
            bw.write(checkBalanced(s) + "\n");
        }

        bw.flush();
    }

    static String checkBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int p = 0;
        while (p < s.length()) {
            char charP = s.charAt(p);
            switch (charP) {
                case '(':
                case '[':
                    stack.push(charP);
                    break;
                case ')':
                    if (!stack.isEmpty() && ('(' == stack.peek())) {
                        stack.pop();
                    } else {
                        return "no";
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && ('[' == stack.peek())) {
                        stack.pop();
                    } else {
                        return "no";
                    }
                    break;
                default:
            }
            p++;
        }
        if (stack.isEmpty()) {
            return "yes";
        }
        stack.clear();
        return "no";
    }
}