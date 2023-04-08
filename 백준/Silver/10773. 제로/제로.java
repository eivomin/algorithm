import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            int a = Integer.parseInt(br.readLine());
            if(a != 0)
                stack.push(a);
            else
                stack.pop();
        }

        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();

        System.out.println(sum);
        br.close();
    }
}