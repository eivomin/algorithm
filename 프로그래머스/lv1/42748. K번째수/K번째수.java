import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int x = commands[i][0]; 
            int y = commands[i][1];
            int k = commands[i][2];
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<array.length; j++){
                if(j >= x-1 && j <= y-1) list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(k-1);
        }
        return answer;
    }
}