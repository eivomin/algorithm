import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, res;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        res = new int[M];

        for(int i=0; i<N; i++)
            arr[i] = i+1;

        perm_duplicate(0);
        System.out.println(sb.toString());
    }

    private static void perm_duplicate(int idx) {
        if(idx == M){
            for(int a : res)
                sb.append(a+" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<arr.length; i++){
            res[idx] = arr[i];
            perm_duplicate(idx+1);
        }
    }
}