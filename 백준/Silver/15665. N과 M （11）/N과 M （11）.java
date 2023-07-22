import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 정렬 후 중복제거 후 중복순열
    static int N, M;
    static int[] arr, res;
    static StringBuilder sb1, sb2;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res = new int[M];
        sb2 = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        hashset_perm_duplicate(0);

        System.out.println(sb2.toString());
    }

    private static void hashset_perm_duplicate(int idx) {
        if(idx == M){
            sb1 = new StringBuilder();

            for(int a : res){
                sb1.append(a+" ");
            }

            if(!set.contains(sb1.toString())){
                set.add(sb1.toString());
                sb2.append(sb1.toString()).append("\n");
            }
            return;
        }

        for(int i=0; i<N; i++){
            res[idx] = arr[i];
            hashset_perm_duplicate(idx+1);
        }
    }
}