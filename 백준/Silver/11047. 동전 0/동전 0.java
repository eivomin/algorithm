import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[N-1-i] = Integer.parseInt(br.readLine());

        int sum = K;
        int cnt = 0;

        for(int i=0; i<N; i++){
            if(sum/arr[i] > 0){
                int mok = sum/arr[i];
                sum -= mok*arr[i];
                cnt += mok;
            }
        }

        System.out.println(cnt);

    }
}