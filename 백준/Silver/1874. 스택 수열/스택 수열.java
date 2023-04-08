import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        ArrayList<Character> list = new ArrayList<>(); // 연산 부호 집어넣어
        Stack<Integer> stack = new Stack<>();   //숫자 집어넣어

        int idx = 1;

        for(int i=1; i<=n; i++){
            stack.push(i);
            list.add('+');
            while(!stack.isEmpty() && stack.peek() == arr[idx]){
                stack.pop();
                list.add('-');
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty()){
            for(Character c : list)
                sb.append(c+"\n");
        }else
            sb.append("NO\n");

        System.out.println(sb.toString());
        br.close();
    }
}