package doit.ch04.sec4_퀵정렬.boj11004;

import java.io.*;
import java.util.*;

public class BOJ11004 {

    // 시간초과
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        quickSort(arr, 0, n-1);

        bw.write(arr[k-1]);
        bw.flush();
        bw.close();
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 1. pivot 설정. 오른쪽 끝
        int pivot = arr[end];

        int i = start;
        int j = end-1;

        while(true) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            swap(arr, i, j);
            if (i > j) break;
        }

        swap(arr, end, i);

        quickSort(arr, start, i-1);
        quickSort(arr, i+1, end);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
