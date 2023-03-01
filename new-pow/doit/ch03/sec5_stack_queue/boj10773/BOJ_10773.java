package doit.ch03.sec5_stack_queue.boj10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<K; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp != 0) {
                result += temp;
                stack.push(temp);
            } else {
                result -= stack.pop();
            }
        }

        System.out.println(result);

    }
}
