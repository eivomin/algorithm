import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 1;
        for(int k=min; k<max; k++){
            int cnt = 0;
            visited = new boolean[N][N];
            //안전영역 k 이하로 초기화
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] <= k){
                        visited[i][j] = true;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int d=0; d<4; d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                queue.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }

    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}