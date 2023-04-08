import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board, dist;
    static Queue<Pair> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];

        queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) queue.add(new Pair(i,j));
                if(board[i][j] == 0) dist[i][j] = -1;
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }

    static void bfs(){

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(dist[nx][ny] >=0) continue;
                dist[nx][ny] = dist[cur.x][cur.y]+1;
                queue.add(new Pair(nx, ny));
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