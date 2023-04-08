import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // deque에 들어가는 숫자
        int M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++)
          arr[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++)
            deque.add(i);

        int idx = 1;
        int cnt = 0;
        for(int i=0; i<M; i++){
            idx = 1;
            Iterator<Integer> iter = deque.iterator();
            while(iter.hasNext()){
                if(iter.next() == arr[i])
                    break;
                idx++;
            }

            int front = idx - 1;
            int back = deque.size() + 1 - idx;

            if(front < back){
                for(int j=0; j<front; j++){
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
                deque.pollFirst();
            }else{
                for(int j=0; j<back; j++){
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
                deque.pollFirst();
            }
        }
        System.out.println(cnt);
        br.close();
    }
}