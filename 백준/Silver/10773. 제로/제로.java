import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0)
                stack.add(tmp);
            else
                stack.pop();
        }

        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();
        System.out.println(sum);
    }
}