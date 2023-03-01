package doit.ch03_스택_큐.p10773_제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1 {
    // https://www.acmicpc.net/problem/10773
    // 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다. 가 무슨 뜻?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        int sum = 0;
        for(int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }

}
