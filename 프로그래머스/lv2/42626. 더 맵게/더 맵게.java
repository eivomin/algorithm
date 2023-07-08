import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int a : scoville) pq.add(a);
        
        while(!pq.isEmpty()){
            if(pq.peek() >= K) break;
            if(pq.size() < 2) break;
            int a = pq.poll();
            int b = pq.poll();
            int c = a+(2*b);
            pq.add(c);
            answer++;
        }
        
        if(pq.poll() < K) answer = -1;
    
        return answer;
    }
}