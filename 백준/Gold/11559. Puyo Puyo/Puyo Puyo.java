import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main {
    static char[][] map;

    static int cnt = 0;
    static boolean isPop = false;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for(int i=0; i<12; i++){
            String str = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = str.charAt(j);
            }
        }

        while(true){
            isPop = false;

            bfs();
            onFloor();

            if(!isPop) break;

            cnt++;
        }

        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Puyo> queue = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(map[i][j] != '.' && !visited[i][j]){
                    ArrayList<int[]> list = new ArrayList<>();

                    queue.add(new Puyo(i, j, map[i][j]));
                    list.add(new int[] {i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        Puyo p = queue.poll();

                        for(int d=0; d<4; d++){
                            int nx = p.x+dx[d];
                            int ny = p.y+dy[d];
                            if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                            if(!visited[nx][ny] && map[nx][ny] == p.color){
                                queue.add(new Puyo(nx, ny, map[nx][ny]));
                                list.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    if(list.size() >= 4){
                        for(int k=0; k<list.size(); k++){
                            int x = list.get(k)[0];
                            int y = list.get(k)[1];

                            map[x][y] = '.';
                            isPop = true;
                        }
                    }
                }
            }
        }
    }

    private static void onFloor() {
        for(int j=0; j<6; j++){
            down(j);
        }
    }

    private static void down(int j) {
        Queue<Puyo> puyo = new LinkedList<>();
        int idx = 11;

        for(int i=11; i>=0; i--){
            if(map[i][j] != '.'){
                puyo.add(new Puyo(i, j, map[i][j]));
                map[i][j] = '.';
            }
        }

        while (!puyo.isEmpty()){
            Puyo p = puyo.poll();

            char color = p.color;

            map[idx][j] = color;

            idx--;
        }
    }

    static class Puyo{
        int x, y;
        char color;
        public Puyo(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}