import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static int[] dr = { -1, 1, 0, 0, 0, 0 };
    static int[] dc = { 0, 0, 0, 0, 1, -1 };
    static int[] dz = { 0, 0, -1, 1, 0, 0 };
    static char[][][] map;
    static int[][][] dist;
    static int start_x, start_y, start_z;
    static int end_x, end_y, end_z;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            boolean flag = false;

            if (L == 0 && R == 0 && C == 0)
                return;

            map = new char[R][C][L];
            dist = new int[R][C][L];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String str = in.readLine();
                    for (int c = 0; c < C; c++) {
                        map[r][c][l] = str.charAt(c);
                        dist[r][c][l] = -1;
                        if (map[r][c][l] == 'S') {
                            start_x = r;
                            start_y = c;
                            start_z = l;
                        } else if (map[r][c][l] == 'E') {
                            end_x = r;
                            end_y = c;
                            end_z = l;
                        }
                    }
                }
                in.readLine();
            }

            Queue<Pos> queue = new LinkedList<>();

            dist[start_x][start_y][start_z] = 0;
            queue.add(new Pos(start_x, start_y, start_z));

            while (!queue.isEmpty()) {
                Pos pos = queue.poll();

                if (pos.x == end_x && pos.y == end_y && pos.z == end_z) {
                    System.out.println("Escaped in " + dist[pos.x][pos.y][pos.z] + " minute(s).");
                    flag = true;
                    break;
                }
                for (int d = 0; d < 6; d++) {
                    int nr = pos.x + dr[d];
                    int nc = pos.y + dc[d];
                    int nz = pos.z + dz[d];

                    if (nr < 0 || nc < 0 || nz < 0 || nr >= R || nc >= C || nz >= L)
                        continue;
                    if (dist[nr][nc][nz] >= 0 || map[nr][nc][nz] == '#')
                        continue;
                    queue.add(new Pos(nr, nc, nz));
                    dist[nr][nc][nz] = dist[pos.x][pos.y][pos.z] + 1;

                }

            }

            if (!flag)
                System.out.println("Trapped!");
        }

    }

    static class Pos {
        int x, y, z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}