import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M; i<=N; i++){
            if(isPrime(i)) System.out.println(i);
        }
    }

    private static boolean isPrime(int N) {
        if(N == 1) return false;

        for(int i=2; i<=(int)Math.sqrt(N); i++){
            if(N % i == 0) return false;
        }
        return true;
    }
}