import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            while(!stack.isEmpty()){
                if(stack.peek().height > arr[i]){
                    sb.append(stack.peek().idx+1+" ");
                    stack.push(new Top(i, arr[i]));
                    break;
                }else
                    stack.pop();
            }

            if(stack.isEmpty()){
                sb.append(0+" ");
                stack.push(new Top(i, arr[i]));
            }
        }

        System.out.println(sb.toString());
    }

    static class Top{
        int idx;
        int height;
        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
}