package doit.ch04.sec4_퀵정렬.boj11004;

import java.io.*;
import java.util.*;

public class BOJ11004 {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        quickSort(0, n-1);

        bw.write(String.valueOf(arr[k-1]));
        bw.flush();
        bw.close();
    }

    private static void quickSort(int start, int end) {
        // 1. pivot 설정. 오른쪽 끝
        int pivot = arr[(start+end)/2];
        int i = start;
        int j = end;

        while(i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++; j--;
            }
        }

        swap((start+end)/2, i);

        if (start < j) quickSort(start, j);
        if (end > i) quickSort(i, end);
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
