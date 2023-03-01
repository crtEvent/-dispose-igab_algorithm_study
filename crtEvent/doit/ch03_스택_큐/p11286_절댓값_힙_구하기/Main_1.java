package doit.ch03_스택_큐.p11286_절댓값_힙_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Comparator<Integer> comparator = (o1, o2) -> {
          int first_abs = Math.abs(o1);
          int second_abs = Math.abs(o2);

          if(first_abs == second_abs) {
              return o1 > o2 ? 1 : -1; // 두 절대값이 같으면 음수 우선 정렬
          } else {
            return first_abs - second_abs; // 절대값을 기준으로 정렬
          }

        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for(int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }
    }
}
