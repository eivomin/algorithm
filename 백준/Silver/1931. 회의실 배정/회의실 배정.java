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

        Collections.sort(list, (o1, o2) -> {
            if(o1.end < o2.end) return -1;
            else if(o1.end == o2.end){
                if(o1.start < o2.start) return -1;
                else return 1;
            }
            else return 1;
        });

        int cnt = 1;
        int end = list.get(0).end;
        for(int i=1; i<N; i++){
            if (list.get(i).start >= end) {
                end = list.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static class Time{
        int start, end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}