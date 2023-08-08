import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i=2; i<=N; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }

        list.add(0);

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while(start <= end && end < list.size()){
            if(sum < N){
                sum += list.get(end++);
            }else{
                if(sum == N){
                    cnt++;
                }
                sum -= list.get(start++);
            }
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;

        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}