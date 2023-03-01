package doit.ch03.sec5_stack_queue.boj17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n]; // 입력 배열
        int[] nge = new int[n]; // 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // 수열 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        for (int i = 0; i < nge.length; i++) {
            bw.write(nge[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
