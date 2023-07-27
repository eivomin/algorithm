import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++)
            set.add(br.readLine());
        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (o1, o2) -> {
           // 1. 길이가 짧은 것 부터
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() == o2.length()){
                // 같으면 사전 순으로
                return o1.compareTo(o2);
            }else return 1;
        });
        list.forEach(System.out::println);
    }
}