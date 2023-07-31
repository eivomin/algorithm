import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        while(m > 0){
            Arrays.sort(arr);
            long tmp = arr[0]+arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
            m--;
        }

        long sum = 0;
        for(long a : arr)
            sum += a;

        System.out.println(sum);
    }
}