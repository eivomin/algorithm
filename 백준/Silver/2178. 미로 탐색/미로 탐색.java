import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr, dist;
    static Queue<Pair> queue;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++)
            Arrays.fill(dist[i], -1);

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(dist[N-1][M-1]+1);

    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        dist[i][j] = 0;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            for(int d=0; d<4; d++){
                int nr = cur.x+dr[d];
                int nc = cur.y+dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(dist[nr][nc] >= 0 || arr[nr][nc] != 1) continue;
                queue.add(new Pair(nr,nc));
                dist[nr][nc] = dist[cur.x][cur.y]+1;
            }
        }
    }


    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}