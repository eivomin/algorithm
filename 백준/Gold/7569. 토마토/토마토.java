import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int x, y, z;
        public Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int H, M, N;
    static int[][][] board, dist;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {0, 0, -1, 1, 0, 0};
    static Queue<Pair> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        board = new int[N][M][H]; // 세 가 높
        dist = new int[N][M][H];
        queue = new LinkedList<>();

        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++){
                    int num = Integer.parseInt(st.nextToken());
                    board[i][j][k] = num;
                    if(num == 0) dist[i][j][k] = -1;
                    if(num == 1) queue.add(new Pair(i,j,k));

                }
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;

        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(dist[i][j][k] == -1){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(){

        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int dir=0; dir<6; dir++){
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                int nz = cur.z+dz[dir];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if(dist[nx][ny][nz] >= 0) continue;
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z]+1;
                queue.add(new Pair(nx, ny, nz));
            }
        }
    }
}