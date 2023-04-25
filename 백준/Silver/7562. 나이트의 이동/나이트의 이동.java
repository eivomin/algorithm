import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] dist = new int[N][N];
            int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
            int[] dy = { -2, -1, 1, 2, -2, -1, 1, 2 };
            for(int i=0; i<N; i++)
                Arrays.fill(dist[i], -1);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<Pair> queue = new LinkedList<>();
            dist[startX][startY] = 0;

            queue.add(new Pair(startX, startY));

            while(!queue.isEmpty()){
                Pair cur = queue.poll();
                if(cur.x == endX && cur.y == endY){
                    System.out.println(dist[cur.x][cur.y]);
                    break;
                }
                for(int d=0; d<8; d++){
                    int nx = cur.x+dx[d];
                    int ny = cur.y+dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(dist[nx][ny] >= 0) continue;
                    queue.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y]+1;
                }
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