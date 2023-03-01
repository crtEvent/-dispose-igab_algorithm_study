package doit.ch03_스택_큐.p17298_오큰수_구하기;

import java.io.*;
import java.util.Stack;

public class Main_2_Book {
    
    // 오큰수
    // https://www.acmicpc.net/problem/17298

    private static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] result = new int[N];
        String[] readLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(readLine[i]);
        }

        // (!) Stack에 값을 넣는게 아니고 index를 넣는구나
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            result[stack.pop()] = -1;
        }

        // 와... 이걸 print()로 출력하니까 시간 초과 나오네;;;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
