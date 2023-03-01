package doit.ch03_스택_큐.p1874_스택_수열;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTester {

    public static void main(String[] args) throws IOException {
        int max = 100_000_000;
        long startTime;
        long endTime;
        long execTime;

        startTime = System.currentTimeMillis();

        Deque<Integer> stack = new ArrayDeque<>(max);

        for(int i = 0; i <= max; i++) {
            stack.addFirst(i);
        }

        endTime = System.currentTimeMillis();
        execTime = (endTime - startTime);
        System.out.println("push 실행 시간: "+(long) execTime);


        startTime = System.currentTimeMillis();
        for(int i = 0; i <= max; i++) {
            stack.pollFirst();
        }

        endTime = System.currentTimeMillis();
        execTime = (endTime - startTime);
        System.out.println("pop 실행 시간: "+(long) execTime);
    } // end - main()
}
