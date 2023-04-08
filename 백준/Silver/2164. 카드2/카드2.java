import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<N; i++)
            queue.add(i+1);

        int last = N;

        while(!queue.isEmpty()){
            if(queue.size() == 1)
                break;
            queue.poll();
            last = queue.poll();
            queue.add(last);
        }
        System.out.println(last);
        br.close();
    }
}