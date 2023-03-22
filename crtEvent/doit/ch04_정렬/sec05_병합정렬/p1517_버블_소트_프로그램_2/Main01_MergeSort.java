package doit.ch04_정렬.sec05_병합정렬.p1517_버블_소트_프로그램_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01_MergeSort {
    // [시간 초과]

    // 예시 1
    // 주어진 배열 [3, 2, 1]
    // loop1 : [2, 3, 1] swap+1
    // loop1 : [2, 1, 3] swap+1
    // lopp2 : [1, 2, 3] swap+1
    // 총 3번의 swap

    // 예시 2
    // 주어진 배열 [3, 4, 1, 2]
    // loop1 : [3, 1, 4, 2] swap+1
    // loop1 : [3, 1, 2, 4] swap+1
    // loop2 : [1, 3, 2, 4] swap+1
    // loop2 : [1, 2, 3, 4] swap+1
    // 총 4번의 swap

    // 아 뭘 어떻게 구해야 하나요??
    // Q. 주어진 배열을 버블 정렬할 때 몇 번의 swap이 발생하는지 묻고 있다.
    // 책이 이해가 안가서 블로그를 찾아 봤는데
    // 버블정렬은 언제 swap이 일어나는가?
    // 1. i와 j번째 원소가 있을 때 (i < j && A[i] > A[j])를 만족하는 경우 swap이 일어난다.(Inversion counting <- 이걸 머지 정렬 or 세그먼트 트리 로 구할 수 있다.)
    // - https://blog.naver.com/PostView.nhn?blogId=raylee00&logNo=222215714721&parentCategoryNo=&categoryNo=79&viewDate=&isShowPopularPosts=true&from=search
    // - 1번의 조건은 merge정렬에서 병합할때의 조건과 같다! 따라서 배열을 merge 정렬할 때 `첫 번째 배열의 비교값 > 두 번째 배열의 비교값 = A[part1] > A[part2]`인 경우를 count하면 된다.

    // [다른 방식] 우측 원소부터 자기 앞쪽에 있는 원소들 중 자기보다 큰 수가 있으면 swap이 일어난다 <- 세그먼트 트리 사용한 방식 (이해 못함)
    // - https://velog.io/@ks1ksi/%EB%B0%B1%EC%A4%80-1517%EB%B2%88-%EB%B2%84%EB%B8%94-%EC%86%8C%ED%8A%B8
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        String[] S = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(S[i]);
        }

        mergerSort(A);

        System.out.println(result);

    }

    private static void mergerSort(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, temp, 0, A.length-1);
    }

    private static void mergeSort(int[] A, int[] temp, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(A, temp, start, middle);
            mergeSort(A, temp, middle + 1, end);
            merge(A, temp, start, middle, end);
        }
    }

    private static void merge(int[] A, int[] temp, int start, int middle, int end) {
        temp = A.clone();
        int part1 = start;
        int part2 = middle + 1;
        int mergeIndex = start;

        while(part1 <= middle && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                A[mergeIndex++] = temp[part1++];
            } else {
                result += part2 - mergeIndex;    // part2에서 삽입 위치(mergeIndex)까지의 개수만큼 이동한 것 = swap 발생 횟수
                A[mergeIndex++] = temp[part2++]; // 두 번째 배열에 값(temp[part2])이 첫 번째 배열의 값(temp[part1])보다 작다면
            }
        }

        for(int i = 0; i <= middle - part1; i++) {
            A[mergeIndex + i] = temp[part1 + i];
        }
    }

}
