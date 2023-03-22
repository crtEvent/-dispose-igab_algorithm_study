package doit.ch04_정렬.sec03_삽입정렬.p11399_ATM_인출시간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main01 {
    
    // 삽입 정렬 설명만 듣고 작성해 본 코드
    // 1차 수정 : System.arraycopy 쓸때 월본 배열 사용
    // 2차 수정 : 합 배열 + 합 배열의 합 구하기를 하나로 합침

    // [선택정렬]
    // 1. 입력값을 오름차순으로 정렬 한다(삽입 정렬 사용)
    // 2. 합 배열을 만든다
    // 3. 합 배열의 합을 구한다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 삽입 정렬
        for(int i = 1; i < N; i++) {
            int insertPosition = -1; // 삽입할 위치
            for(int j = i-1; j >= 0; j--) { // 이미 정렬된 구간의 마지막 index부터 0번째까지 돌며 현재 원소를 삽일할 위치를 찾는 과정
                if(P[j] > P[i]) {
                    insertPosition = j;
                }
            }
            if(insertPosition != -1) { // -1이면 이동이 없는 것
                int tempValue = P[i];
                System.arraycopy(P, insertPosition, P, insertPosition+1, i-insertPosition);
                P[insertPosition] = tempValue;
            }

        } // for - end

        // 합 배열 구하기
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
