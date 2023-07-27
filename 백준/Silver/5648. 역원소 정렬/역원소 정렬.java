import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        List<Long> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            long tmp = reverse(sc.nextLong()+"");
            list.add(tmp);
        }

        Collections.sort(list);
        list.forEach(System.out::println);
    }

    private static long reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) != 0)
                sb.append(s.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}