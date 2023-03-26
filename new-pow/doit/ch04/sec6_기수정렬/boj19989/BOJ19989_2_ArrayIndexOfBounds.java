package doit.ch04.sec6_기수정렬.boj19989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 책에 있는 방법을 참고해 수정
// 예제는 통과하나 백준에서 runtime error
// 이해를 제대로 못한거같음.........
public class BOJ19989_2_ArrayIndexOfBounds {
    private static int[] bucket;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        result = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        redixSort(arr,1);

        for (int i=0; i<n; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void redixSort(int[] arr, int jari) {
        if (jari>=100000) return;   // 문제 조건에 주어짐

        bucket = new int[10];

        for (int i=0; i<arr.length; i++) {
            bucket[(arr[i]/jari) % 10]++;
        }

        // 자리수 계산
        for (int i=1; i<10; i++) {
            bucket[i] += bucket[i-1];
        }

        // 다시 넣기
        for (int i = arr.length-1; i >= 0; i--) {
            result[bucket[(arr[i])/jari]-1] = arr[i];
            bucket[(arr[i]/jari) % 10]--;
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = result[i];
        }

        redixSort(arr, jari*10);
    }
}
