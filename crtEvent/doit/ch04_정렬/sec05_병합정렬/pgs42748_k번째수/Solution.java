package doit.ch04_정렬.sec05_병합정렬.pgs42748_k번째수;

public class Solution {
    // 머지 정렬 안보고 풀 수 있을지 테스트 해봤는데 역시 몇 번 틀림
    // 1. merge() while문 조건 틀림(기억해야 될 점: 두 구역의 처음 요소부터 비교한다!)
    // 2. System.arraycopy() 범위 잘못 지정해서 틀림
    // 3. 마지막에 남은 배열 복사해주기 까먹어서 틀림

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] A = new int[commands[i][1] - commands[i][0] + 1];
            System.arraycopy(array, commands[i][0]-1, A, 0, commands[i][1] - commands[i][0] + 1);
            mergeSort(A);
            answer[i] = A[commands[i][2] - 1];
        }

        return answer;
    }

    public void mergeSort(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, temp,0, A.length - 1);
    }

    public void mergeSort(int[] A, int[] temp, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(A, temp, start, middle);
            mergeSort(A, temp, middle + 1, end);
            merge(A, temp, start, middle, end);
        }
    }

    public void merge(int[] A, int[] temp, int start, int middle, int end) {
        int part1 = start;
        int part2 = middle + 1;
        int index = start;

        System.arraycopy(A, 0, temp, 0, A.length);

        while(part1 <= middle && part2 <= end) {
            if(A[part1] <= A[part2]) {
                A[index++] = temp[part1++];
            } else {
                A[index++] = temp[part2++];
            }
        }

        for(int i = 0; i <= middle - part1; i++) {
            A[index + i] = temp[part1 + i];
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution.solution(array, commands);

        for(int result : answer) {
            System.out.println(result);
        }
    }
}
