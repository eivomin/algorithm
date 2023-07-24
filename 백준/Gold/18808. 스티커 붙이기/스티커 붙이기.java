import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int R, C;
    static int[][] note;
    static int[][] sticker = new int[12][12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        note = new int[N][M];

        for(int tc=0; tc<K; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<C; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 붙이면 다음으로 넘어가야됨 못 붙이면 90도 돌리기
            check: for(int rot=0; rot<4; rot++){
                for(int x=0; x <= N-R; x++){
                    for(int y=0; y <= M-C; y++){
                        if(postable(x,y)) break check;
                    }
                }
                rotate();
            }
        }
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                count += note[i][j];
            }
        }
        System.out.println(count);
    }

    private static boolean postable(int x, int y) {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(note[x+i][y+j] == 1 && sticker[i][j] == 1){
                    return false;
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(sticker[i][j] == 1){
                    note[x+i][y+j] = 1;
                }
            }
        }

        return true;
    }

    private static void rotate() {
        int[][] temp = new int[12][12];

        for(int i=0; i<R; i++)
            System.arraycopy(sticker[i], 0, temp[i], 0, C);

        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                sticker[i][j] = temp[R-1-j][i];
            }
        }
        int tmp = R;
        R = C;
        C = tmp;
    }
}