package doit.ch04_정렬.sec05_병합정렬.p2751_수정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01 {
    // 병합정렬: 유튜브 보고 따라한거
    // https://www.youtube.com/watch?v=QAyl79dCO_k
    // 배열을 나눌때 진짜 배열을 계속 생성하는게 아니라 temp 배열 하나를 사용
    // temp 배열에 필요한 값만 복사하여 temp 배열 내에서 구간을 나누고 비교한다

    private static void mergeSort(int[] A) {
        int[] temp = new int[A.length]; // 임시 저장소
        mergeSort(A, temp, 0 , A.length - 1);
    }

    private static void mergeSort(int[] A, int[] temp, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(A, temp, start, middle);
            mergeSort(A, temp, middle + 1, end);
            merge(A, temp, start, middle, end);
        }
    }

    private static void merge(int[] A, int temp[], int start, int middle, int end) {
        for(int i= start; i <= end; i++) {
            temp[i] = A[i]; // 임시 저장소에원본 배열을 필요한 만큼만 복사
        }

        int part1 = start; // 첫 번째 구간의 첫 index
        int part2 = middle + 1; // 두 번째 구간의 첫 index
        int index = start; // 결과 배열(=원본 배열)에 저장하기 위한 인덱스

        // 첫 번째 구간이 끝까지 가거나 두 번째 구간이 끝까지 갈때 까지 돌린다
        while(part1 <= middle && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                // 첫 번째 구간의 값이 두 번째 구간의 값보다 작으면 -> 첫 번째 구간의 값을 원본 배열로 이동
                A[index++] = temp[part1++];
            } else {
                // 첫 번째 구간의 값이 두 번째 구간의 값보다 크면 -> 두 번째 구간의 값을 원본 배열로 이동
                A[index++] = temp[part2++];
            }
        }

        // 두 번때 배열은 끝까지 갔는데, 첫 번째 배열에 값이 남아있다면?
        // 남아있는 원소 수 만큼 반복문 돌면서, 남아있는 원소를 원본 배열에 삽입
        // ! 반대로 앞쪽 배열은 끝까지 갔는데, 두 번째 배열에 값이 남아있다면?
        // 두 번째 배열은 이미 원본 배열의 뒤에 정렬된 상태로 남아 있기 때문에 따로 작업이 필요 없다
        for(int i = 0; i <= middle - part1; i++) {
            A[index + i] = temp[part1 + i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(A);

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(A[i]).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
