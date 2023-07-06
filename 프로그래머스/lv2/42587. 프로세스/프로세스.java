import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : priorities){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                //값이 일치할 경우
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    //인덱스도 동일할 경우
                    if(i == location)
                        return answer;
                }
            }
        }
        return answer;
    }
}