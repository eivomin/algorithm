import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        long x = 0;
        HashMap<Long, Integer> hashMap = new HashMap<>();

        for(int i=0; i<N; i++){
            long a = Long.parseLong(br.readLine());
            hashMap.put(a, hashMap.getOrDefault(a, 0)+1);

            if(hashMap.get(a) > max){
                max = hashMap.get(a);
                x = a;
            }else if(hashMap.get(a) == max){
                x = Math.min(x, a);
            }
        }
        System.out.println(x);
    }
}