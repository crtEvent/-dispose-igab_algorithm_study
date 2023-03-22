package doit.ch04_정렬.sec04_퀵정렬.p11004_k_번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main03 {

    // 유튜브 보고 따라한거
    // 이게 이해하기는 더 쉽지만, K를 활용하여 개선하지 못함
    // https://www.youtube.com/watch?v=7BDzle2n47c

    private static void quickSort(int[] A, int start, int end) {
        if(start < end) {
            int pivot = partition(A, start, end);
            if(start < pivot - 1) quickSort(A, start, pivot - 1);
            if(end > pivot) quickSort(A, pivot, end);
        }
    }

    private static int partition(int[] A, int start, int end) {
        int pivot = A[(start + end) / 2];
        while(start <= end) {
            while(A[start] < pivot) start++;
            while(A[end] > pivot) end--;
            if(start <= end) {
                swap(A, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        quickSort(A, 0, N - 1);
        System.out.println(A[K - 1]);
    }
}
