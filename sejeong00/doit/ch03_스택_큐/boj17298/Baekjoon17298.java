package doit.ch03_스택_큐.boj17298;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon17298 {
    //TODO: 복습
    //peek()보다 작으면 push()함
    //peek()보다 크면 peek()보다 작아질 때까지 pop()함
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        Stack<Integer> stack = new Stack<>(); //오큰수를 못 구한 수의 인덱스들의 집합

        for (int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();
        }

        stack.push(0);

        for (int i = 1; i < cnt; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < cnt; i++) {
            bw.write(arr[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }

}
