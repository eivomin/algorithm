import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // N : 인원 수, K : 최대 인원 수 / 1~6학년
        int[][] arr = new int[2][6];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken()); // 0: 여, 1: 남
            int Y = Integer.parseInt(st.nextToken()); // 학년
            arr[S][Y-1]++;
        }

        int cnt = 0;
        for(int i=0; i<2; i++){
            for(int j=0; j<6; j++){
                if(arr[i][j] > 0 && arr[i][j] <= K){
                    cnt ++;
                }else if(arr[i][j] > K) {
                    if(arr[i][j]%K == 0)
                        cnt+= (arr[i][j]/K);
                    else
                        cnt+= (arr[i][j]/K+1);
                }
            }
        }

        System.out.println(cnt);
        br.close();



    }
}