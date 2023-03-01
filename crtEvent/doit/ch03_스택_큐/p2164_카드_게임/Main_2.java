package doit.ch03_스택_큐.p2164_카드_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) { // 카드를 큐에 저장하기
            myQueue.add(i);
        }

        while (myQueue.size() > 1) { // 카드가 1장 남을 때까지
            myQueue.poll(); // 맨 위의 카드를 버림
            myQueue.add(myQueue.poll()); // 맨 위의 카드를 가장 아래 카드 밑으로 이동
        }

        System.out.println(myQueue.poll()); // 마지막으로 남은 카드 출력
    }
}
