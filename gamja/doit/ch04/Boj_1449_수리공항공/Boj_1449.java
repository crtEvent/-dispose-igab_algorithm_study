package doit.ch04.Boj_1449_수리공항공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Boj_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (start < arr[i]) {
                start = arr[i];
                start += m - 0.5;
                result++;
            }
        }
        System.out.println(result);
    }
}
