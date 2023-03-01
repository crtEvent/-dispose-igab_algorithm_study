package doit.ch03_스택_큐.p17298_오큰수_구하기;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] result = new int[N];
        String[] readLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(readLine[i]);
        }

        for(int i = 0; i < N; i++) {
            int index = A[i];

            for(int j = i + 1; j < N; j++) {
                if(index < A[j]) {
                    result[i] = A[j];
                    break;
                }
            }

            if(result[i] == 0) {
                result[i] = -1;
            };

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
