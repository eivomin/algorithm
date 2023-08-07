import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<A; i++)
            treeSet.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<B; i++){
            int key = Integer.parseInt(st.nextToken());
            treeSet.remove(key);
        }

        System.out.println(treeSet.size());
        for(Integer a : treeSet)
            sb.append(a).append(" ");
        System.out.println(sb);

    }
}