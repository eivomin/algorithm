import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L, C; // M N
    static char[] arr, sel;
    static StringBuilder sb1, sb2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        sel = new char[L];
        sb2 = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<C; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        combination(0, 0);
        System.out.println(sb2.toString());
    }

    private static void combination(int idx, int s_idx) {
        if(s_idx == L){
            sb1 = new StringBuilder();

            for(char a : sel)
                sb1.append(a);

            if(check(sb1.toString())) return;

            sb2.append(sb1.toString());
            sb2.append("\n");
            return;
        }

        for(int i=idx; i<C; i++){
            sel[s_idx] = arr[i];
            combination(i+1, s_idx+1);
        }
    }

    private static boolean check(String str) {
        List<Character> moeumList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int moeumCnt = 0;
        int jaeumCnt = 0;

        for(int i=0; i<str.length(); i++){
            if(moeumList.contains(str.charAt(i))) moeumCnt++;
            else jaeumCnt++;
        }

        if(moeumCnt >= 1 && jaeumCnt >= 2) return false;
        return true;
    }
}