import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        if(arr.length == 1) return new int[] {-1};
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != min)
                list.add(arr[i]);
        }
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}