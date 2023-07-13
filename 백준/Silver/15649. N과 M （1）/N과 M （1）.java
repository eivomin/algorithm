import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = i+1;
        res = new int[M];
        visited = new boolean[N];
        perm(0);
    }

    private static void perm(int idx) {
        if(idx == M){
            for(int a : res)
                System.out.print(a+" ");
            System.out.println();
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