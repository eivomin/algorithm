import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] origin = new int[N];  // 원본 배열
        int[] sorted = new int[N];  // 정렬 할 배열
        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        for(int i=0; i<N; i++){
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        int rank = 0;
        for(int v : sorted){
            if(!rankingMap.containsKey(v)){
                rankingMap.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int key : origin)
            sb.append(rankingMap.get(key)).append(" ");

        System.out.println(sb);
    }
}