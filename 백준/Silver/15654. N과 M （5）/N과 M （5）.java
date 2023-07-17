import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, res;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        res = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        perm(0);
        System.out.println(sb.toString());
    }

    private static void perm(int idx) {

        if(idx == M){
            for(int a : res)
                sb.append(a+" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                res[idx] = arr[i];
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}