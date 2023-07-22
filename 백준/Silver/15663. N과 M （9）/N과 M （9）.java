import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, res;
    static boolean[] visited;
    static StringBuilder sb1, sb2;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        res = new int[M];
        visited = new boolean[N];
        sb2 = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        hashset_perm(0);
        System.out.println(sb2.toString());
    }

    private static void hashset_perm(int idx) {
        if(idx == M){
            // 중복 검사 확인
            sb1 = new StringBuilder();
            for(int a : res)
                sb1.append(a+" ");

            if(!set.contains(sb1.toString())){
                set.add(sb1.toString());
                sb2.append(sb1.toString()).append("\n");
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                res[idx] = arr[i];
                hashset_perm(idx+1);
                visited[i] = false;
            }
        }
    }
}