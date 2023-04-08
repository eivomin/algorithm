import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            }else if(cmd.equals("top")){
                if(!stack.isEmpty())
                    sb.append(stack.peek()+"\n");
                else sb.append(-1+"\n");
            }else if(cmd.equals("pop")){
                if(!stack.isEmpty())
                  sb.append(stack.pop()+"\n");
                else sb.append(-1+"\n");
            }else if(cmd.equals("size")){
                sb.append(stack.size()+"\n");
            }else if(cmd.equals("empty")){
                if(stack.isEmpty())
                    sb.append(1+"\n");
                else sb.append(0+"\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}