import java.io.*;
import java.util.*;


public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int area, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sum);
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        visited[i][j] = true;

        area = 0;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int d=0; d<4; d++){
                int nr = pair.x+dr[d];
                int nc = pair.y+dc[d];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(visited[nr][nc] || arr[nr][nc] != 1) continue;
                queue.add(new Pair(nr,nc));
                visited[nr][nc] = true;
            }
            area++;
        }

        sum = Math.max(area,sum);
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