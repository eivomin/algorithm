import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++)
            if(Integer.parseInt(st.nextToken()) == target)
                cnt++;

        System.out.println(cnt);
        br.close();
    }
}