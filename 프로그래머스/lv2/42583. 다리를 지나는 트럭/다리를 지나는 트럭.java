import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0; // 다리를 건너는 트럭들의 무게 합
        
        for(int t : truck_weights){
            while(true){
                //큐가 비어있다면 다음 트럭 삽입
                if(queue.isEmpty()){
                    queue.add(t);
                    sum += t;
                    answer++;
                    break;
                }
                //큐의 사이즈와 다리의 길이가 같다면 큐에서 처음 값 빼고 최대 무게 -
                else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }
                //큐가 비어있지 않을 때
                else{
                    //다음 트럭이 최대 무게 초과
                    if(sum + t > weight){
                        queue.add(0);
                        answer++;
                    }
                    //다음 트럭이 최대 무게 이내
                    else{
                        queue.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        //걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer+bridge_length;
    }
}