package doit.ch03_스택_큐.p17298_오큰수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4_Only_Array {

    // Stack 안쓰고 배열 쓰니까 더 빠름 ( 1044ms -> 816ms)
    //  - Stack.pop() 은 synchronized가 붙어 있어서 lock을 거는 작업이 추가됨
    //  - 그래서 pop()을 많이 할 땐 Stack이 아니라 ArrayDeque를 쓴다????
    //     - [[Java] Stack 클래스는 무엇이고 문제점은 무엇일까?](https://devlog-wjdrbs96.tistory.com/244)<br>
    //     - [자바에서 Vector와 Stack 컬렉션이 쓰이지 않는 이유?](https://aahc.tistory.com/8)<br>

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        int[] stack = new int[N];	// 스택처럼 쓸 배열
        int top = -1;	// 스택의 맨 위 원소를 가리키는 변수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            while (top != - 1 && A[stack[top]] < A[i]) {
                result[stack[top]] = A[i];
                top--;
            }
            top++;
            stack[top] = i;
        }

        for(int i = top; i >= 0; i--) {
            result[stack[i]] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int nge : result) {
            sb.append(nge).append(' ');
        }

        System.out.println(sb);
    }
}
