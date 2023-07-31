import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] map, copy;
    static boolean[] visited;
    static int[] floor;
    static int[] dir;

    static int[] dx = {-1, 1, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        copy = new int[5][5][5];

        for(int k=0; k<5; k++){
            for(int i=0; i<5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<5; j++){
                    copy[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        visited = new boolean[5];
        floor = new int[5];
        dir = new int[5];
        Floor(0); // 순열

        ans = (ans == Integer.MAX_VALUE? -1 : ans);
        System.out.println(ans);

    }

    private static void Floor(int idx) {
        if(idx == 5){
            direction(0); // 각 층의 방향 정해주기
            return;
        }

        for(int i=0; i<5; i++){
            if(!visited[i]){
                visited[i] = true;
                floor[idx] = i;
                Floor(idx+1);
                visited[i] = false;
            }
        }
    }

    private static void direction(int idx) { // 중복순열, 방향 골라주기
        if(idx == 5) {
            map = new int[5][5][5]; // 새로운 조합이 생길 때 마다 할당
            change();   // 층이랑 방향 설정
            if(map[0][0][0] == 1) // 들어갈 수 있는 길이면 들어가기
                bfs();  //bfs 돌리기
            return;
        }
        for(int i=0; i<4; i++){
            dir[idx] = i;
            direction(idx+1);
        }
    }

    private static void change() {
        for(int k=0; k<5; k++){ //층별, 방향별 값 설정
            if(dir[k] == 0){ //원상태 그대로
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        map[k][i][j] = copy[floor[k]][i][j];
                    }
                }
            }
            else if(dir[k] == 1){ //반시계 방향 90도
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        map[k][i][j] = copy[floor[k]][j][4-i];
                    }
                }
            }
            else if(dir[k] == 2){ //반시계 방향 180도
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        map[k][i][j] = copy[floor[k]][4-i][4-j];
                    }
                }
            }
            else if(dir[k] == 3){ //반시계 방향 270도
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        map[k][i][j] = copy[floor[k]][4-j][i];
                    }
                }
            }
        }
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[5][5][5];
        Queue<Point> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new Point(0, 0, 0, 0));

        while(!queue.isEmpty()){

            Point p = queue.poll();

            if(p.k == 4 && p.x == 4 && p.y == 4){ // 도착
                if(p.cnt < ans)
                    ans = p.cnt;
                return;
            }

            for(int d=0; d<6; d++){ //전,후,좌,우,상,하
                if(d<4){ //전후좌우. 같은 층 안에서만 움직일 것
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                    if(visited[p.k][nx][ny]) continue;
                    if(map[p.k][nx][ny] == 1){
                        visited[p.k][nx][ny] = true;
                        queue.add(new Point(p.k, nx, ny, p.cnt+1));
                    }
                }
                else{ //상하. 층 이동 합
                    int nk = p.k+dx[d];

                    if(nk < 0 || nk >= 5) continue;
                    if(visited[nk][p.x][p.y]) continue;
                    if(map[nk][p.x][p.y] == 1){
                        visited[nk][p.x][p.y] = true;
                        queue.add(new Point(nk, p.x, p.y, p.cnt+1));
                    }

                }
            }
        }
    }

    static class Point{
        int k, x, y, cnt;
        public Point(int k, int x, int y, int cnt){
            this.k = k;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}