import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr, res;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        res = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        powerset(0);

        if(S == 0) cnt--;
        System.out.println(cnt);
    }

    private static void powerset(int idx) {
        if(idx == N){
            int sum = 0;
            for(int i=0; i<N; i++){
                if(res[i] != 0){
                    sum += res[i];
                }
            }
            if(sum == S) cnt++;
            return;
        }
        res[idx] = arr[idx];
        powerset(idx+1);
        res[idx] = 0;
        powerset(idx+1);
    }
}