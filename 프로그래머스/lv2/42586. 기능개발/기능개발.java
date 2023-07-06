import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Function> queue = new LinkedList<>();
        
        int day = 0;
        
        for(int i=0; i<progresses.length; i++){
            if((100-progresses[i])%speeds[i] != 0){
                day = (100-progresses[i])/speeds[i]+1;
            }else{
                day = (100-progresses[i])/speeds[i];
            }
            queue.add(new Function(i+1, day));
        }
        
        Function fc = queue.poll();
        int target_day = fc.day;
        int cnt = 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        
        while(!queue.isEmpty()){
            Function fc1 = queue.poll();
            if(target_day >= fc1.day){
                   cnt++;     
            }else{
                list.add(cnt);
                target_day = fc1.day;
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    static class Function{
        int index;
        int day;
        public Function(int index, int day){
            this.index = index;
            this.day = day;
        }
    }
}