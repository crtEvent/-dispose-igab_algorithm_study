package doit.ch04_정렬.sec05_병합정렬.p1431_시리얼번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main01_ImplementsComparable {

    // Comparable 을 직접 구현하여 정렬하도록 함
    // 정렬은 Collections.sort() 로 정렬
    // 정렬을 mergeSort 로 하려고 했으나 실패함...

    private static class Guitar implements Comparable<Guitar> {
        private String serialNumber;

        public Guitar(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public int getSerialNumberLength() {
            return serialNumber.length();
        }

        public int getSumOfDigit() {
            char[] charArr = serialNumber.toCharArray();
            int sum = 0;
            for(char character : charArr) {
                if(character >= 48 && character <= 57) {
                    sum += character - 48;
                }
            }

            return sum;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public String toString() {
            return serialNumber;
        }

        @Override
        public int compareTo(Guitar o) {
            int compare = 0;
            // A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
            compare = this.getSerialNumberLength() - o.getSerialNumberLength();

            // A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
            if(compare == 0) {
                compare = this.getSumOfDigit() - o.getSumOfDigit();
            }

            // 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
            if(compare == 0) {
                compare = this.getSerialNumber().compareTo(o.getSerialNumber());
            }
            return compare;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Guitar> guitars = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            guitars.add(new Guitar(br.readLine()));
        }

        Collections.sort(guitars);

        guitars.stream().forEach(System.out::println);
    }
}
