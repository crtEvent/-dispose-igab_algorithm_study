package doit.ch04.sec6_기수정렬.boj19989;

import java.io.*;
import java.util.*;

// 결과는 잘 나온다.
// 메모리 초과..;
public class BOJ19989_1_outMemory {
    private static Queue<Integer>[] bucket;
    private static int cnt;

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        cnt = n;

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        bucket = new LinkedList[10];
        for (int i=0; i<10; i++) {
            bucket[i] = new LinkedList<>();
        }

        redixSort(arr,1);

        for (int i=0; i<n; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void redixSort(int[] arr, int jari) {
        if (jari>=100000) return;

        // 자리수에 맞게 정렬
        for (int i=0; i<arr.length; i++) {
            if (arr[i]/jari == 0) cnt --;
            bucket[(arr[i]/jari) % 10].add(arr[i]);
        }

        // arr에 다시 넣기
        for (int i = 0, j = 0; i < 10; ++i) {
            while (!bucket[i].isEmpty()) {
                arr[j++] = bucket[i].poll();
            }
        }

        redixSort(arr, jari*10);
    }
}
