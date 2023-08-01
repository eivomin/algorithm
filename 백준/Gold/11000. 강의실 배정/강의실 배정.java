import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);

        for(int i=1; i<N; i++){
            if(pq.peek() <= list.get(i).start) pq.poll();
            pq.add(list.get(i).end);
        }

        System.out.println(pq.size());

    }

    static class Time{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}