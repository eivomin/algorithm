import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        // 막대 과자의 최대 길이를 구하기 위한 이분 탐색
        long left = 1;
        long right = arr[N-1];

        while (left <= right){
            int count = 0;
            long mid = (left+right)/2;

            // 막대 과자 길이를 특정한 뒤 몇명의 조카에게 줄 수 있는지 계산
            for(int i=0; i<N; i++){
                count += arr[i] / mid;
            }

            // 조카의 수보다 막대 과자가 많이 나오면 해당 길이만큼 나누어줄 수 있음
            // 계속 반복하면서 범위를 좁혀나가고, 막대 과자의 길이를 최대로 특정함
            if (count >= M) {
                if(result < mid) result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}