import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, sel;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sel = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        combination(0,0);

        System.out.println(sb.toString());

    }

    private static void combination(int idx, int s_idx) {
        if(s_idx == M){
            for (int a : sel)
                sb.append(a+" ");
            sb.append("\n");
            return;
        }

        for(int i=idx; i<arr.length; i++){
            sel[s_idx] = arr[i];
            combination(i+1, s_idx+1);
        }
    }
}