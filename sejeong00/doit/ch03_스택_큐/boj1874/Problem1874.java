package doit.ch03_스택_큐.boj1874;

import java.io.IOException;
import java.util.*;

public class Problem1874 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int num = 1;

        while(arr.size() < cnt){
            int target = sc.nextInt();
            if(stack.isEmpty() || target > stack.peek()) {
                if(num > target){
                    System.out.println("NO");
                    return;
                }
                while (num <= target) {
                    stack.push(num++);
                    sb.append("+\n");
                }
            }else if(target <= stack.peek()){
                while(target < stack.peek()){
                    stack.pop();
                    sb.append("-\n");
                }
            }
            arr.add(stack.pop());
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
