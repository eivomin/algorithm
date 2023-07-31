import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int curDir = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(curX, curY, curDir);
        System.out.println(cnt);

    }

    private static void clean(int row, int col, int dir) {
        // 1. 현재 위치를 청소한다.
        if(map[row][col] == 0){
            map[row][col] = 2;
            cnt++;
        }

        // 2. 왼쪽방향부터 차례대로 탐색한다.
        boolean flag = false;
        int origin = dir;
        for(int d=0; d<4; d++){
            int nd = (dir+3) % 4;
            int nx = row + dx[nd];
            int ny = col + dy[nd];

            if (nx > 0 && ny > 0 && nx < N && ny < M) {
                if(map[nx][ny] == 0){ // 아직 청소하지 않은 공간이라면
                    clean(nx, ny, nd);
                    flag = true;
                    break;
                }
            }
            dir = (dir+3)%4;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if(!flag){
            int nbd = (origin + 2) % 4;
            int nbx = row + dx[nbd];
            int nby = col + dy[nbd];

            if(nbx > 0 && nby > 0 && nbx < N && nby < M){
                if(map[nbx][nby] != 1){
                    clean(nbx, nby, origin);    // 바라보는 방향 유지한 채 후진
                }
            }
        }
    }
}