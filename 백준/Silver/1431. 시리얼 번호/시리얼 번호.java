import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        Collections.sort(list, (o1, o2) -> {
            // 1. 길이 짧은 것이 먼저 온다.
            if(o1.length() < o2.length())
                return -1;
            // 2. 길이가 같다면 숫자 합 작은 합 먼저 온다.
            else if(o1.length() == o2.length()){
                if(numSum(o1) == numSum(o2))
                    return o1.compareTo(o2);
                else
                    return Integer.compare(numSum(o1), numSum(o2));
            }
            else{
                return 1;
            }
        });

        list.forEach(System.out::println);
    }

    private static int numSum(String o1) {
        int sum = 0;

        for(int i=0; i<o1.length(); i++){
            if(o1.charAt(i)-'0' >= 0 && o1.charAt(i)-'0' <= 9)
                sum += o1.charAt(i)-'0';
        }
        return sum;
    }
}