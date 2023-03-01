package 추가문제풀이.스택_큐.boj10773;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10773 {
    // 키워드
    // 최대값 1,000,000 => 시간복잡도 고려해야함
    // 가장 최근에 쓴 수 => 스택 사용 가능
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for(int i = 0; i < cnt; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
