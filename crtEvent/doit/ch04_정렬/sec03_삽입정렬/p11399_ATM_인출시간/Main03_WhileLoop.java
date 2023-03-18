package doit.ch04_정렬.sec03_삽입정렬.p11399_ATM_인출시간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main03_WhileLoop {

    public static void insertionSort(int[] a, int size) {
        int i, j, temp;
        for(i = 1; i < size; i++) {
            temp = a[i];
            j = i;
            while(j > 0 && (a[j-1] > temp)) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        insertionSort(P, N);

        int[] sumArr = new int[N];
        sumArr[0] = P[0];
        for(int i = 1; i < N; i++) {
            sumArr[i] = P[i] + sumArr[i-1];
        }

        // 합 구하기
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum = sum + sumArr[i];
        }

        System.out.println(sum);
    }
}
