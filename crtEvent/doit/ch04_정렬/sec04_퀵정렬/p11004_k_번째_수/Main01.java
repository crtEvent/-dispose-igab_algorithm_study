package doit.ch04_정렬.sec04_퀵정렬.p11004_k_번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01 {
    // 퀵정렬
    // 책에 있는 코드
    // 이론은 대충 이해했는데 코드는 솔직히 이해 못했어요..

    public static void quickSort(int[] A, int start, int end, int K) {
       if(start < end) {
           int pivot = partition(A, start, end);
           if(pivot == K)  return;
           if(K < pivot) quickSort(A, start, pivot - 1, K); // K가 pivot보다 작으면 왼쪽 그룹만 정렬
           if(K > pivot) quickSort(A, pivot + 1, end, K); // K가 pivot보다 크면 왼쪽 그룹만 정렬
       }
    }

    public static int partition(int[] A, int start, int end) {
        if(start + 1 == end) {
            if(A[start] > A[end]) {
                swap(A, start, end);
                return end;
            }
        }

        int middle = (start + end) / 2;
        swap(A, start, middle);
        int pivot = A[start];
        int i = start + 1;
        int j = end;

        while(i <= j) {
            // pivot보다 작은 수가 나올 때까지 j--
            while(pivot < A[j] && j > 0) {
                j--;
            }

            // pivot 보다 큰 수가 나올 때까지 i++
            while(pivot > A[i] && i < A.length - 1) {
                i++;
            }

            if(i <= j) {
                swap(A, i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;

        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);

    }
}
