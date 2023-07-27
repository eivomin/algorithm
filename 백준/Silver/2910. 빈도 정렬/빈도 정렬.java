import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Msg> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)){
                Msg msg = map.get(tmp);
                msg.cnt++;
                map.put(tmp, msg);
            }else{
                map.put(tmp, new Msg(tmp, 1, i));
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            if(map.get(o1).cnt > map.get(o2).cnt)
                return -1;
            else if(map.get(o1).cnt == map.get(o2).cnt)
                return map.get(o1).idx-map.get(o2).idx;
            else return 1;
        });

        for (int key : keySet){
            for(int i=0; i<map.get(key).cnt; i++){
                System.out.print(key+" ");
            }
        }
    }

    static class Msg{
        int num, cnt, idx;
        public Msg(int num, int cnt, int idx){
            this.num = num;
            this.cnt = cnt;
            this.idx = idx;
        }
    }
}