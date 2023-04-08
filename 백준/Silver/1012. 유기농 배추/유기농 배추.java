import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> queue;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    private static void bfs(int i, int j) {
        queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int d=0; d<4; d++){
                int nr = cur.x+dr[d];
                int nc = cur.y+dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] != 1) continue;
                queue.add(new Pair(nr,nc));
                visited[nr][nc] = true;
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