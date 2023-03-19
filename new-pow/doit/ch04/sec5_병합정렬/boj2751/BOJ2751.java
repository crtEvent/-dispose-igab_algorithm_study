package doit.ch04.sec5_병합정렬.boj2751;

import java.util.*;
import java.io.*;

public class BOJ2751 {

    static int[] sorted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        sorted = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        mergeSort(a, 0, n-1);

        // 출력
        for (int i=0; i<n; i++) {
            bw.write(a[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void merge(int[] a, int m, int middle, int n) {
        int i =m;
        int j =middle+1; // 배열 나눠지는 지점부터 첫번째 요소
        int k =m;


        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= n) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i++];
            } else {
                sorted[k] = a[j++];
            }
            k++;
        }

        // 남은 데이터 삽입
        if (i > middle) {
            for (int t=j; t<=n; t++) {
                sorted[k] = a[t];
                k++;
            }
        } else {
            for (int t=i; t<=middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }

        // 정렬된 배열 삽입
        for (int t=m; t<=n; t++) {
            a[t] = sorted[t];
        }
    }

    private static void mergeSort(int[] a, int m, int n) {
        if (m < n) { // 크기가 1보다 큰 경우
            int middle = (m+n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle+1, n);

            merge(a, m, middle, n);    // 나중에 합치기
        }
    }

}
