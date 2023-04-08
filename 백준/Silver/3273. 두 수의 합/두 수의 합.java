import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j]>x) break;
                if(arr[i]+arr[j] == x) cnt++;
            }
        }
        System.out.println(cnt);
    }
}