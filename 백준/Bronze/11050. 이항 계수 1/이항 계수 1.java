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

        int sum = 1;
        for(int i=0; i<K; i++){
            sum *= (N-i);
        }

        int mid_sum = 1;
        for(int i=1; i<=K; i++){
            mid_sum *= i;
        }

        System.out.println(sum / mid_sum);

    }
}