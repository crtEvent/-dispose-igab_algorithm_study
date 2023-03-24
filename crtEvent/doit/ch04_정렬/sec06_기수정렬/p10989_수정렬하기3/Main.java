package doit.ch04_정렬.sec06_기수정렬.p10989_수정렬하기3;

import java.io.*;

public class Main {
    // 책에 있는 코드
    // 참고 : https://m.blog.naver.com/adamdoha/222015268529
    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A, 5);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; ++i) {
            sb.append(A[i]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static void Radix_Sort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) // 최대 자리수 만큼 반복
        {
            int[] bucket = new int[10]; // 자리수 분포를 정장할 공간
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++; // 일의 자리 부터 시작
            }
            for (int i = 1; i < 10; i++) { // 합배열을 이용하여 index 계산(원소가 들어갈 위치를 미리 계산)
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) { // 현재 자리수 기준으로 정렬하기
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i]; // (A[i] / jarisu % 10) : 현재 원소의 해당 자리수
                bucket[(A[i] / jarisu) % 10]--; // 하나 배치했으니 분포에서 카운트를 빼준다
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
            }
            jarisu = jarisu * 10; // 자리수 증가
            count++;
        }
    }

}

