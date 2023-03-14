package doit.ch04.boj1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Boj_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        sb.append("\n");

        System.out.println(sb);
    }
}
