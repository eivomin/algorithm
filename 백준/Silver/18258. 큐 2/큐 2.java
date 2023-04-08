import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(str.equals("front")){
                if(!queue.isEmpty())
                    sb.append(queue.peek()+"\n");
                else sb.append(-1+"\n");
            }else if(str.equals("back")){
               if(!queue.isEmpty())
                   sb.append(last+"\n");
               else sb.append(-1+"\n");
            }else if(str.equals("size")){
                sb.append(queue.size()+"\n");
            }else if(str.equals("empty")){
                if(queue.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }else if(str.equals("push")){
                int tmp = Integer.parseInt(st.nextToken());
                queue.add(tmp);
                last = tmp;
            }else if(str.equals("pop")){
                if(!queue.isEmpty())
                    sb.append(queue.poll()+"\n");
                else sb.append(-1+"\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}