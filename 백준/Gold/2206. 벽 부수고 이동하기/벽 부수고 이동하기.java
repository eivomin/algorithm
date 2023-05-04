import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1, false));

        boolean[][][] visited = new boolean[N][M][2];

        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            if(cur.x == N-1 && cur.y == M-1){
                System.out.println(cur.cnt);
                return;
            }

            for(int d=0; d<4; d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 0){ // 벽이 아니면
                    if(!cur.destroyed && !visited[nx][ny][0]){ // 부신 벽이 여태까지 없었으면
                        queue.add(new Pair(nx, ny, cur.cnt+1, false));
                        visited[nx][ny][0] = true;
                    }else if(cur.destroyed && !visited[nx][ny][1]){ // 벽을 한번 부신 적이 있으면
                        queue.add(new Pair(nx, ny, cur.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }else if(map[nx][ny] == 1){ // 벽이면
                    if(!cur.destroyed){ // 한번도 벽을 부순적이 없으면 부순다!
                        queue.add(new Pair(nx, ny, cur.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                    //한번 부순 적이 있으면 또 부수고 갈 수 없기 때문에 Pass
                }
            }
        }
        System.out.println(-1);
    }

    static class Pair{
        int x, y, cnt;
        boolean destroyed;

        public Pair(int x, int y, int cnt, boolean d){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }
}