import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = (1 << N)-1;

        sb.append(cnt+"\n");
        Hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
    }

    private static void Hanoi(int n, int start, int mid, int to) {
        if (n==1){
            sb.append(start+ " "+to+ "\n");
            return;
        }
        // n-1개를 start -> mid로 이동
        Hanoi(n-1, start, to, mid);

        // 1개를 start -> to로 이동
        sb.append(start+ " "+to+"\n");

        // n-1개를 mid -> to로 이동
        Hanoi(n-1, mid, start, to);
    }
}