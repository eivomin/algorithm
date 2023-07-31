import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Flower> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Flower(Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.start < o2.start)
                return -1;
            else if(o1.start == o2.start){
                if(o1.end > o2.end)
                    return -1;
                else if(o1.end == o2.end)
                    return 0;
                else return 1;
            }else return 1;
        });

        int ans = 0;
        int idx = 0;
        int start = 301;
        int max = 0;

        while (start < 1201){
            max = 0;
            boolean flag = false;

            for(int i=idx; i<N; i++){
                Flower cur = list.get(i);
                if(cur.start > start) break;
                if(cur.start <= start && max < cur.end){
                    max = cur.end;
                    idx = i+1;
                    flag = true;
                }
            }
            if(flag){
                start = max;
                ans++;
            }else break;
        }

        if(max < 1201)
            System.out.println(0);
        else
            System.out.println(ans);
    }


    static class Flower{
        int start;
        int end;
        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}