import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] dist;
    static int N;
    static ArrayList<Integer> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = str.charAt(j)-'0';
            }
        }

        int cnt = 0;
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1){
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for (Integer a : list) {
            System.out.println(a);
        }

    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        board[i][j] = 0;

        int count = 0;
        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            for(int d=0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(board[nx][ny] == 0) continue;
                queue.add(new Pair(nx, ny));
                board[nx][ny] = 0;
            }
            count++;
        }

        list.add(count);

    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}