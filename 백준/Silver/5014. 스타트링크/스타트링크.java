import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] map = new int[F+1];
        Arrays.fill(map, -1);

        int[] dx = {U, -D};

        map[S] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            if(tmp == G){
                System.out.println(map[tmp]);
                return;
            }
            for(int d=0; d<2; d++){
                int nx = tmp+dx[d];
                if(nx <= 0 || nx > F) continue;
                if(map[nx] >= 0) continue;
                queue.add(nx);
                map[nx] = map[tmp]+1;
            }
        }

        System.out.println("use the stairs");

    }
}