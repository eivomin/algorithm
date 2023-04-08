import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(str.equals("front")){
                if(!queue.isEmpty())
                    sb.append(queue.peek()+"\n");
                else sb.append(-1+"\n");
            }else if(str.equals("back")){
                int qsize = queue.size();
                int back = -1;
                for(int j=0; j<qsize; j++){
                    int tmp2 = queue.poll();
                    if(j == qsize-1)
                        sb.append(tmp2+"\n");
                    queue.add(tmp2);
                }
                if(qsize == 0) sb.append(-1+"\n");
            }else if(str.equals("size")){
                sb.append(queue.size()+"\n");
            }else if(str.equals("empty")){
                if(queue.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }else if(str.equals("push")){
                int tmp = Integer.parseInt(st.nextToken());
                queue.add(tmp);
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