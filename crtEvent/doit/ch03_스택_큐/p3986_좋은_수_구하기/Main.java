package doit.ch03_스택_큐.p3986_좋은_수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Character> stack;

        for(int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            stack = new Stack<>();

            //stack.push(word[0]);
            for(int j = 0; j < word.length; j++) {

                if(stack.empty()) {
                    stack.push(word[j]);
                    continue;
                }

                char target = stack.peek();
                if(target == word[j]) {
                    stack.pop();
                } else {
                    stack.push(word[j]);
                }
            }

            if(stack.empty()) {
                result++;
            }

        }

        System.out.println(result);

    }
}
