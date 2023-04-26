import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int n = x1; n < x2; n++) {
                for (int m = y1; m < y2; m++) {
                    map[m][n] = -1;
                }
            }
        }

        list = new ArrayList<>();
        int cnt = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] >= 0){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int a : list) {
            System.out.print(a+" ");
        }

    }

    private static void bfs(int i, int j) {
        map[i][j] = -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));

        int cnt = 0;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            for(int d=0; d<4; d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[nx][ny] < 0) continue;
                queue.add(new Pair(nx, ny));
                map[nx][ny] = -1;
            }
            cnt++;
        }
        list.add(cnt);
    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}