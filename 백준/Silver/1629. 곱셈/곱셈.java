import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B,C));
        // A를 B번 곱한 수 , C로 나눈 나머지
    }

    private static long pow(long a, long b, long c) {
        if (b == 1)
            return a % c;
        long temp = pow(a, b/2, c)%c;

        // b가 짝수일 때
        if (b%2 == 0){
            return (temp * temp)%c;
        }else{
            // b가 홀수일 때
            return (((temp*temp)%c)*a)%c;
        }

    }
}