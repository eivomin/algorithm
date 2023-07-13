import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        cnt = new int[3];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }

        paperCnt(0, 0, N);

        System.out.println(cnt[0]+"\n"+cnt[1]+"\n"+cnt[2]);
    }

    private static void paperCnt(int x, int y, int size) {
        if(isAll(x,y,size)){
            cnt[arr[x][y]]++;
        }else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    paperCnt(x+(size/3)*i, y+(size/3)*j, size/3);
                }
            }
        }

    }

    private static boolean isAll(int x, int y, int size) {
        int num = arr[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}