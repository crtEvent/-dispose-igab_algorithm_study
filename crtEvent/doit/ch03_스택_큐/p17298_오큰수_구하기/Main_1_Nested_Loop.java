package doit.ch03_스택_큐.p17298_오큰수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1_Nested_Loop {
    // 수열의 최대 크기 = 1_000_000 이므로 반복문으로 풀면 제한시간 초과!

    // 1. 수열을 입력 받는다.
    // 2. 수열의 크기만큼 반복문 돌린다.
    // 3. i 번째 수를 저장한다
    //  4. 남음 수열의 크기만큼 또 반복문을 돌린다
    //  5. i+n 번째 수를 저장한 변수와 비교한다
    //  6. 비교시 i번째 수열이 저장한 변수보다 크면 NGE! -> 출력

    private static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] result = new int[N];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            int index = A[i];

            for(int j = i + 1; j < N; j++) {count++;
                if(index < A[j]) {
                    result[i] = A[j];
                    break;
                }
            }

            if(result[i] == 0) {
                result[i] = -1;
            };

        }
        System.out.println("count: "+ count);
        for(int i = 0; i < A.length; i++) {
            System.out.print(result[i]);
            if(i < A.length - 1){
                System.out.print(" ");
            }
        }

    }
}
