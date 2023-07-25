import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int a : arr)
            sb.append(a+"\n");
        System.out.println(sb.toString());
    }
}