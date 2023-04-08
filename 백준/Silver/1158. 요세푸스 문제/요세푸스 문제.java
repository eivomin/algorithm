import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++)
            queue.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() != 0){
            for(int i=0; i<K; i++){
                int a = queue.poll();
                if(i == (K-1))
                    sb.append(a+", ");
                else queue.add(a);
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());

        br.close();
    }
}