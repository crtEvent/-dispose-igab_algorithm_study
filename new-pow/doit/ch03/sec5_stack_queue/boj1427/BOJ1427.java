package doit.ch03.sec5_stack_queue.boj1427;

import java.io.*;
import java.util.*;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] nArr = br.readLine().toCharArray();

        for (int i=0; i<nArr.length-1; i++) {
            for (int j=i+1; j<nArr.length; j++) {
                if (nArr[i] < nArr[j]) {
                    char temp = nArr[i];
                    nArr[i] = nArr[j];
                    nArr[j] = temp;
                }
            }
        }

        System.out.println(nArr);

    }
}
