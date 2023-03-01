package doit.ch03_스택_큐.boj11286;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon11286 {
    //절댓값 힙 구현하기
    //TODO: 복습 (이런 문제를 보면 우선순위 큐가 떠오르도록)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Abs = Math.abs(o1);
                int o2Abs = Math.abs(o2);
                if(o1Abs == o2Abs){
                    return o1 - o2;
                }else{
                    return o1Abs - o2Abs;
                }
            }
        });

        for(int i = 0; i < n; i++){
            int input = sc.nextInt();
            if(input == 0){
                System.out.println(queue.isEmpty()? 0 : queue.poll());
            }else{
                queue.add(input);
            }
        }
    }
}
