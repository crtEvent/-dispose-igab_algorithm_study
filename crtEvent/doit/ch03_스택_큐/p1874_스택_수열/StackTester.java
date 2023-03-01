package doit.ch03_스택_큐.p1874_스택_수열;

import java.io.IOException;
import java.util.Stack;

public class StackTester {

    public static void main(String[] args) throws IOException {
        int max = 100_000_000;
        long startTime;
        long endTime;
        long execTime;

        startTime = System.currentTimeMillis();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= max; i++) {
            stack.push(i);
        }

        endTime = System.currentTimeMillis();
        execTime = (endTime - startTime);
        System.out.println("push 실행 시간: "+(long) execTime);


        startTime = System.currentTimeMillis();
        for(int i = 0; i <= max; i++) {
            stack.pop();
        }

        endTime = System.currentTimeMillis();
        execTime = (endTime - startTime);
        System.out.println("pop 실행 시간: "+(long) execTime);
    } // end - main()

}
