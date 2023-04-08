import java.io.*;
import java.util.*;

public class Main {
    static char[][] mapYes, mapNo;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mapYes = new char[N][N]; // 적록색약 배열
        mapNo = new char[N][N]; // 적록색약 배열
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                mapNo[i][j] = str.charAt(j);
                if(mapNo[i][j] == 'G') mapYes[i][j] = 'R'; // 초록색이면 빨간색으로 바꿈
                else mapYes[i][j] = mapNo[i][j];
            }
        }

        // 적록색약 bfs
        int cntYes = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j, mapYes);
                    cntYes++;
                }
            }
        }

        // 적록색약 X bfs
        visited = new boolean[N][N];
        int cntNo = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j, mapNo);
                    cntNo++;
                }
            }
        }
        System.out.println(cntNo+" "+cntYes);
        br.close();
    }

    private static void bfs(int i, int j, char[][] map) {
        char tmp = map[i][j];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int d=0; d<4; d++){
                int nr = cur.x+dr[d];
                int nc = cur.y+dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] != tmp) continue;
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