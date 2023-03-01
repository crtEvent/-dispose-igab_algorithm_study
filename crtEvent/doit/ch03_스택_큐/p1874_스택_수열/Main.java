package doit.ch03_스택_큐.p1874_스택_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {

    // 스택 수열 - 스택으로 오름차순 수열 만들기
    // https://www.acmicpc.net/problem/1874

    // 입력값: 4, 3, 6, 8, 7, 5, 2, 1
    // stack: +1, +2, +3, +4, -4, -3, +5 +6, -6, +7, +8, -8, -7, -2, -1

    // 4               <- 이거 n번 돌리고
    // 1, 2, 3, 4      <- 이거 위에꺼 까지
    // -(4)

    // 3
    // -(3)

    // 6
    // 5, 6
    // -(6)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 1; // 1~N 까지의 index 역할
        for (int i = 0; i < N; i++) {
            int value = A[i]; // 현재 수열의 수

            if(value >= index) { // 배열에서 꺼내온 값이 인덱스와 같아 질 때 까지 push해 준다
                for(int j = index; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                index = value + 1;
            } else {
                if(stack.peek() != value) {
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-\n");
        } // end - for

        System.out.println(sb.toString());
    } // end - main()

}
