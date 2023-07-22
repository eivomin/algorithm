import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    //정렬 후 중복 제거 조합
    static int N, M;
    static int[] arr, sel;
    static StringBuilder sb1, sb2;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        sb2 = new StringBuilder();

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        combination_hashset(0, 0);
        System.out.println(sb2.toString());
    }

    private static void combination_hashset(int idx, int s_idx) {
        if(s_idx == M){
            sb1 = new StringBuilder();
            for(int a : sel)
                sb1.append(a+" ");
            if(!set.contains(sb1.toString())){
                set.add(sb1.toString());
                sb2.append(sb1.toString()).append("\n");
            }
            return;
        }

        for(int i=idx; i<N; i++){
            sel[s_idx] = arr[i];
            combination_hashset(i+1, s_idx+1);
        }
    }
}