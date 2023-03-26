package doit.ch04.sec5_병합정렬.boj1431;

import java.io.*;
import java.util.*;

public class BOJ1431 {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        // 정렬
        Arrays.sort(arr, (Comparator<String>) (o1, o2) -> {
            if (o1.length() == o2.length()) {
                if (makeNum(o1) == makeNum(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return makeNum(o1) - makeNum(o2);
                }
            } else {
                return o1.length() - o2.length();
            }
        });

        // 출력
        for (int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int makeNum(String a) {
        int result = 0;
        for (char c : a.toCharArray()) {
            if (Character.isDigit(c)) result += c-'0';
        }
        return result;
    }
}
