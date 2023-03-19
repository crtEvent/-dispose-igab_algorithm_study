package doit.ch04.boj11004;

import java.util.*;
import java.io.*;

public class BOJ11004{

    // 인덱스 오류가 나는 답변...
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        sort(a, 0, n-1);

        System.out.println(a[k-1]);
    }

    private static void sort(int[] a, int start, int end) {    // 시작지점 / 끝지점
        int i = start;
        int j = end;

        int pivotPoint = (i+j)/2;
        int pivot = a[pivotPoint];

        while (i <= j) {
            if (a[i] <= pivot && a[j] >= pivot) {
                swap(a, i, j);
                i++;
                j--;
            }
            if (a[i] < a[pivot]) {
                i++;
            }
            if (a[j] > a[pivot]) {
                j --;
            }
        }

        swap(a, pivotPoint, i);
        if (pivotPoint==end) return;
        if (start < j) sort(a, start, j);
        if (i > end) sort(a, i, end);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
