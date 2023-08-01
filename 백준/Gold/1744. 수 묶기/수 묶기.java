import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int minus = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] <= 0) minus++;
        }

        Arrays.sort(arr);

        int ans = 0;

        // 두 개의 음수는 곱하는 게 최댓 값
        for(int i=1; i<minus; i+=2){
            ans += arr[i-1] * arr[i];
        }

        // 음수의 개수가 홀수 개일 경우 양수와 곱해주면 X -> 음수를 그냥 더해주는 것이 최대 값
        if(minus % 2 == 1)
            ans += arr[minus-1];

        // 양수의 개수가 홀수개일 경우 가장 작은 양수를 더해준다 -> 큰 양수들은 곱해서 더해주는 것이 최대 값
        if((N-minus) % 2 == 1)
            ans += arr[minus];

        // 나머지 양수를 그냥 더하는 것과 두 수를 묶어 곱한 값 중 큰 값을 누적
        for(int i=N-1; i > minus; i-=2){
            int sum = arr[i]+arr[i-1];
            int mul = arr[i]*arr[i-1];

            if(sum > mul)
                ans += sum;
            else ans += mul;
        }

        System.out.println(ans);

    }
}