package doit.ch04.boj1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        boolean flag = false;
//        for (int i = 0; i < arr.length; i++) {
//            flag = false;
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    flag = true;
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//
//                if (flag == false) {
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }

//        boolean changed = false;
//        for (int i = 1; i <= N + 1; i++) {
//            changed = false;
//            for (int j = 1; j <= N - i; j++) {
//                if (A[j] > A[j + 1]) {
//                    changed = true;
//                    int temp = A[j];
//                    A[j] = A[j + 1];
//                    A[j + 1] = temp;
//                }
//            }
//            if (changed == false) {
//                System.out.println(i);
//                break;
//            }
//        }
//    }

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(i, Integer.parseInt(br.readLine())));
        }
    //   System.out.println(points);
        Collections.sort(points);
   //     System.out.println(points);
        int max = 0;
        List<Integer> movePoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
    //        System.out.println(points.get(i).getIndex());
            movePoints.add(points.get(i).getIndex() - i);
            max = Math.max(points.get(i).getIndex() - i, max);
        }
   //     System.out.println(movePoints.toString());
        System.out.println(max + 1);
    }
}

class Point implements Comparable<Point> {
    private int index;
    private int num;

    public Point(int index, int num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compareTo(Point o) {
        return this.num - o.num; //오름차순
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", num=" + num +
                '}';
    }
}

