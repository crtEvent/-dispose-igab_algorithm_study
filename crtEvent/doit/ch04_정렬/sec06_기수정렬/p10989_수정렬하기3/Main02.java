package doit.ch04_정렬.sec06_기수정렬.p10989_수정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main02 {

    // 출처: https://sorjfkrh5078.tistory.com/21
    // 메모리 초과 나옴
    //  - 배열에 직접 값을 넣기 때문에 List 안에 List가 들어감

    public static int[] arr;
    public static long result;

    static final int bucketSize = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();


        radix_Sort(arr.length, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    public static void radix_Sort(int n, int[] arr) {
        //bucket 초기화
        Queue<Integer>[] bucket = new LinkedList[bucketSize];
        for (int i = 0; i < bucketSize; ++i) {
            bucket[i] = new LinkedList<>(); // 배열에 직접 값을 넣는 방식
        }

        int factor = 1;

        //정렬할 자릿수의 크기 만큼 반복한다.
        for (int d = 0; d < 2; ++d) {
            for (int i = 0; i < n; ++i) {
                bucket[(arr[i] / factor) % 10].add(arr[i]);
            }

            for (int i = 0, j = 0; i < bucketSize; ++i) {
                while (!bucket[i].isEmpty()) {
                    arr[j++] = bucket[i].poll();
                }
            }

            factor *= 10;
        }
    }
}
