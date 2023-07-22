import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, sel;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());

            if(K == 0) break;

            N = K;
            arr = new int[N];
            sel = new int[6];
            sb = new StringBuilder();

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            combination(0, 0);
            System.out.println(sb.toString());
            sb.append("\n");

        }
    }

    private static void combination(int idx, int s_idx) {
        if(s_idx == 6){
            for(int a : sel)
                sb.append(a+" ");
            sb.append("\n");
            return;
        }

        for(int i=idx; i<N; i++){
            sel[s_idx] = arr[i];
            combination(i+1, s_idx+1);
        }
    }
}