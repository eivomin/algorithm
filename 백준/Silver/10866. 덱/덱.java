import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int dqsize = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            dqsize = deque.size();

            switch(str){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(dqsize == 0) sb.append(-1+"\n");
                    else sb.append(deque.pollFirst()+"\n");
                    break;
                case "pop_back":
                    if(dqsize == 0) sb.append(-1+"\n");
                    else sb.append(deque.pollLast()+"\n");
                    break;
                case "size":
                    sb.append(dqsize+"\n");
                    break;
                case "empty":
                    if(dqsize == 0) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "front":
                    if(dqsize == 0) sb.append(-1+"\n");
                    else sb.append(deque.peekFirst()+"\n");
                    break;
                case "back":
                    if(dqsize == 0) sb.append(-1+"\n");
                    else sb.append(deque.peekLast()+"\n");
                    break;
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}