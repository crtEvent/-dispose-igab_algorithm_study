package doit.ch04.boj11399;

import java.io.*;
import java.util.*;

public class BOJ11399 {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sum = new int[n];

        // 입력
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        // 1. 기준점 잡기
        for (int i=1; i<n; i++) {
            int addPoint = -1; // 삽입할 지점
            int addValue = -1;

            // 2. 정렬된 arr
            for (int j=0; j<i; j++) {
                if (arr[j]>=arr[i]) {    // 기준점보다 j가 크다면 그 자리에 arr[i] 를 넣기
                    addPoint = j;
                    addValue = arr[i];
                    break;
                }
            }

            if (addPoint!=-1) {
                // 3. 한칸씩 땡기기
                for (int j=i; j>addPoint; j--) {
                    arr[j] = arr[j-1];
                }

                // 자리에 껴넣기
                arr[addPoint] = addValue;
            }

        }

        // 출력
        for (int i=0; i<n; i++) {
            // 4. 합배열 구하기
            // 첫번째 사람은 0.
            for (int j=0; j<=i; j++) {
                sum[i] += arr[j];
            }
        }

        System.out.println(Arrays.stream(sum).sum());
    }
}
