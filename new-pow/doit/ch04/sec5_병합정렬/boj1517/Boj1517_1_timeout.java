package doit.ch04.sec5_병합정렬.boj1517;

import java.io.*;
import java.util.*;

public class Boj1517_1_timeout {
    static int result;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n);

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end-start <2) {    // 크기가 1이라면 종료
            return;
        }

        int middle = (start+end)/2;
        mergeSort(start,middle);
        mergeSort(middle+1,end);

        // 미리 배열 복사
        for (int i=0; i<end; i++) {
            temp[i] = arr[i];
        }

        int index1 = start;    // 병합할 첫번째 배열의 인덱스
        int index2 = middle+1;    // 병합할 두번째 배열의 인덱스
        int tempIndex = start;    // 병합한 배열의 인덱스

        while (index1 <= middle && index2 < end) {
            if (arr[index1] > arr[index2]) {
                result += (index2-tempIndex);    // 남아있는 데이터보다 앞으로 이동하면 버블소트 발생한 것.
                arr[tempIndex++] = temp[index1++];
            } else {
                arr[tempIndex++] = temp[index2++];
            }
        }

        // 남은 데이터 다 넣어주기
        while (index1 <= middle) {
            arr[tempIndex++] = temp[index1++];
        }

        while (index2 < end) {
            arr[tempIndex++] = temp[index2++];
        }
    }



}
