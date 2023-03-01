package 추가문제풀이.스택_큐.boj10828;
import java.io.*;
import java.util.Stack;

public class Baekjoon10828 {
    //백준 10828
    //Scanner로 입력 받으면 시간초과남 BufferedReader로 받으면 안남
    // sout도 BufferedWriter로 바꿔서 쓰자
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < cnt; i++){
            String input = br.readLine();
            String[] inputs = input.split(" ");
            switch(inputs[0]){
                case "push":
                    stack.push(Integer.valueOf(inputs[1]));
                    break;
                case "pop":
                    bw.write((stack.isEmpty()? -1:stack.pop()) + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write((stack.isEmpty()? 1:0) + "\n");
                    break;
                case "top":
                    bw.write((stack.isEmpty()? -1:stack.peek()) + "\n");
                    break;
            }
        }
        bw.flush();
    }
}
