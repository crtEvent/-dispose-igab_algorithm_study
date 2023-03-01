package doit.ch03_스택_큐.p10828_스택_구현하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // https://www.acmicpc.net/problem/10828

    private int[] stack;
    private int pointer = 0;
    StringBuilder sb = new StringBuilder();

    public Main(int capacity) {
        stack = new int[capacity];
    }

    public void push(int X) {
        stack[pointer++] = X;
    }

    public void pop() {
        if(pointer == 0) {
            sb.append("-1" + System.lineSeparator());
            return;
        }
        sb.append(stack[--pointer] + System.lineSeparator());
        stack[pointer] = 0;
    }

    public void size() {
        sb.append(pointer + System.lineSeparator());
    }

    public void empty() {
        if(pointer == 0) {
            sb.append("1" + System.lineSeparator());
            return;
        }
        sb.append("0" + System.lineSeparator());
    }

    public void top() {
        if(pointer == 0) {
            sb.append("-1" + System.lineSeparator());
            return;
        }
        sb.append(stack[pointer - 1] + System.lineSeparator());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Main main = new Main(N);

        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    main.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    main.pop();
                    break;
                case "size":
                    main.size();
                    break;
                case "empty":
                    main.empty();
                    break;
                case "top":
                    main.top();
                    break;
            }
        }

        System.out.println(main.sb.toString());

    }
}
