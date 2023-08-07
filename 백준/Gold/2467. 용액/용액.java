import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[2];
        int[] liquid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(liquid);
        int max = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int start = i+1;
            int end = N-1;
            while (start <= end){
                int mid = (start+end)/2;
                int sum = liquid[i]+liquid[mid];

                if(Math.abs(sum) < max){
                    answer[0] = liquid[i];
                    answer[1] = liquid[mid];
                    max = Math.abs(sum);
                }

                if(sum < 0){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}