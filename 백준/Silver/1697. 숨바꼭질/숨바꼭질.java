import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100002];

        Arrays.fill(dist, -1);
        dist[N] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int d=0; d<3; d++){
                int next = 0;
                if(d == 0){
                    next = cur-1;
                }else if(d == 1){
                    next = cur+1;
                }else{
                    next = cur*2;
                }

                if(next < 0 || next > 100000) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[cur]+1;
                queue.add(next);
            }
        }
        System.out.println(dist[K]);



    }
}